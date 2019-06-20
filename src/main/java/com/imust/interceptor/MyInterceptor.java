package com.imust.interceptor;

import com.imust.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
            return false;
        }
        return true;
    }
}
