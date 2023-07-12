package com.system.design.log.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.system.design.common.util.ThreadLocalUtil;
import com.system.design.entity.User;
import com.system.design.entity.dto.LogDTO;
import com.system.design.log.annotation.LogRecord;
import com.system.design.log.service.AnnoLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;
import java.util.Date;


/**
 * @author zzzk1
 */
@Component
@Slf4j
@Aspect
public class LogRecordAspect {
    @Autowired
    private AnnoLogService annoLogService;
    @Autowired
    private ObjectMapper objectMapper;

    private final SpelExpressionParser expressionParser = new SpelExpressionParser();
    private final DefaultParameterNameDiscoverer discoverer = new DefaultParameterNameDiscoverer();
    public static final TemplateParserContext TEMPLATE_PARSER_CONTEXT = new TemplateParserContext("{{", "}}");

    @Before(value = "@annotation(com.system.design.log.annotation.LogRecord)")
    public void before(JoinPoint joinPoint) {
        try {
            Object[] arguments = joinPoint.getArgs();
            //获得方法对象
            Method method = getMethod(joinPoint);
            LogRecord annotation = method.getAnnotation(LogRecord.class);
            User loginUser = (User) ThreadLocalUtil.get("userInfo");
            LogDTO logDTO = new LogDTO();
            String context;
            EvaluationContext evaluationContext = null;
            try {
                String[] params = discoverer.getParameterNames(method);
                evaluationContext = new StandardEvaluationContext();
                if (params != null) {
                    for (int len = 0; len < params.length; len++) {
                        evaluationContext.setVariable(params[len], arguments[len]);
                    }
                }

            } catch (Exception e) {
                log.error("SystemLogAspect doBefore error", e);
            } finally {
                context = expressionParser.parseExpression(annotation.context(),
                        TEMPLATE_PARSER_CONTEXT).getValue(evaluationContext, String.class);
                logDTO.setOperateDate(new Date());
                logDTO.setOperator(loginUser.getNickName());
                logDTO.setOperationType(annotation.operatorType());
                logDTO.setBizNo(annotation.bizNo());
                logDTO.setContext(context);
                ThreadLocalUtil.put("logDTO", logDTO);
            }

        } catch (Exception e){
            log.error("SystemLogAspect doBefore error",e);
        }
    }

    private Method getMethod(JoinPoint joinPoint){
        Method method = null;
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Object target = joinPoint.getTarget();
        try {
            method = target.getClass().getMethod(methodSignature.getName(),methodSignature.getParameterTypes());
        } catch (NoSuchMethodException e) {
            log.error("SystemLogAspect getMethod error",e);
        }
        return method;
    }

    @Around(value = "@annotation(com.system.design.log.annotation.LogRecord)")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        Object result;
        try {
            result = pjp.proceed();
            // logDTO写入返回值信息 若方法抛出异常，则不会走入下方逻辑
        }catch (Throwable throwable){
            // logDTO写入异常信息
            throw throwable;
        } finally {
            // logDTO发送至数据管道
            LogDTO logDTO = (LogDTO) ThreadLocalUtil.get("logDTO");
                try {
                    annoLogService.saveLog(logDTO);
                } catch (Throwable throwable) {
                    log.error("logRecord send message failure", throwable);
                }
            }
            ThreadLocalUtil.remove("logDTO");
        return result;
        }
    }
