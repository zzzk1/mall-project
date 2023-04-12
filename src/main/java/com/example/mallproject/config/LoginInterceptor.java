package com.example.mallproject.config;

import com.example.mallproject.entity.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    // 不拦截跨域请求相关
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 不拦截跨域请求相关
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }

        // 登录成功，把用户信息存入session
        User user = handleLogin(request, response);
        request.setAttribute("user", user);

        // 放行到Controller
        return super.preHandle(request, response, handler);
    }


    private User handleLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            // 抛异常，请先登录
            throw new Exception("未登录");
        }
        return currentUser;
    }
}
