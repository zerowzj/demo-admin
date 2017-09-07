package com.company.project.adminweb.pattern.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 验证拦截器
 *
 * @author wangzhj
 */
public class ValidateInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        try {

        } catch (Exception ex) {
            throw ex;
        }
        return true;
    }
}
