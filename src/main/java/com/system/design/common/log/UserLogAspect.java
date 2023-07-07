package com.system.design.common.log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.system.design.common.annotation.UserLog;
import com.system.design.common.util.ThreadLocalUtil;

import com.system.design.entity.User;
import com.system.design.entity.dto.UserLogDTO;
import com.system.design.service.UserLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@Aspect
@Component
public class UserLogAspect {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    UserLogService userLogService;

    @Pointcut("@annotation(com.system.design.common.annotation.UserLog)")
    public void pointcut() {}

    @AfterReturning("pointcut()")
    public void afterReturning(JoinPoint point) {
        saveUserLog(point);
    }

    private void saveUserLog(JoinPoint point) {
        // 获取当前登录用户
        User userInfo = (User) ThreadLocalUtil.get("userInfo");

        // 目标方法、以及方法上的@UserLog注解
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        UserLog userLogAnnotation = method.getAnnotation(UserLog.class);
        if (userLogAnnotation == null) {
            return;
        }

        // 收集相关信息并保存
        UserLogDTO userLogDTO = new UserLogDTO();
        userLogDTO.setModuleCode(userLogAnnotation.module().getModuleCode());
        userLogDTO.setContent(getContentJson(point));
        userLogDTO.setTitle(userLogAnnotation.title());
        userLogDTO.setOperatorId(userInfo.getUserId());
        userLogDTO.setOperateTime(new Date());
        userLogDTO.setType(userLogAnnotation.type().getValue());

        userLogService.addSysLog(userLogDTO);
    }

    private String getContentJson(JoinPoint point) {
        String requestType = request.getMethod();
        if ("GET".equals(requestType)) {
            // 如果是GET请求，直接返回QueryString（目前没有针对查询操作进行日志记录，先留着吧）
            return request.getQueryString();
        }

        Object[] args = point.getArgs();
        Object[] arguments = new Object[args.length];

        for (int i = 0; i < args.length; i++) {
            // 只打印客户端传递的参数，排除Spring注入的参数，比如HttpServletRequest
            if (args[i] instanceof ServletRequest
                    || args[i] instanceof ServletResponse
                    || args[i] instanceof MultipartFile) {
                continue;
            }
            arguments[i] = args[i];
        }

        try {
            return objectMapper.writeValueAsString(arguments);
        } catch (JsonProcessingException e) {
            log.error("UserLogAspect#getContentJson JsonProcessingException", e);
        }
        return "";
    }
}
