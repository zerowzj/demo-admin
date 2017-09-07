package com.company.project.adminweb.support.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求上下文
 *
 * @author wangzhj
 */
public class RequestContext {

    /**
     * HttpServletRequest
     */
    private HttpServletRequest request;
    /**
     * HttpServletResponse
     */
    private HttpServletResponse response;
    /**
     * SessionUserInfo
     */
    private SessionUserInfo userInfo;

    public RequestContext(HttpServletRequest request, HttpServletResponse response) {
        this(request, response, null);
    }

    public RequestContext(HttpServletRequest request, HttpServletResponse response, SessionUserInfo userInfo) {
        this.request = request;
        this.response = response;
        this.userInfo = userInfo;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public SessionUserInfo getUserInfo() {
        return userInfo;
    }
}
