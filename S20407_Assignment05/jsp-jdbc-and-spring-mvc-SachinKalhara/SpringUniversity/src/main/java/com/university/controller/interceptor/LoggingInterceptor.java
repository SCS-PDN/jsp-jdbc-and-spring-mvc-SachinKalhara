package com.university.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggingInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String uri = request.getRequestURI();
        if (uri.contains("/login") && request.getMethod().equalsIgnoreCase("POST")) {
            System.out.println("[LOG] Login attempt: " + request.getParameter("email"));
        }
        if (uri.contains("/register/") && request.getMethod().equalsIgnoreCase("POST")) {
            System.out.println("[LOG] Registration attempt by: " + request.getSession().getAttribute("userEmail"));
        }
        return true;
    }
}
