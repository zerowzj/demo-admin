package com.company.project.adminweb.pattern.action;

import com.company.project.adminweb.support.SpringContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Action执行器
 *
 * @author wangzhj
 */
public class ActionExecutor {

    /**
     * 执行
     *
     * @param request
     * @param response
     * @param clazz
     * @return Map<String, Object>
     */
    public static Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response,
                                              Class<? extends Action> clazz) {
        if (!SpringContext.containsBean(clazz)) {
            throw new IllegalStateException("Bean不存在");
        }
        Action action = SpringContext.getBean(clazz);
        return action.doExecute(request, response);
    }

    /**
     * 执行
     *
     * @param request
     * @param response
     * @param name
     * @return Map<String, Object>
     */
    public static Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response,
                                              String name) {

        Action action = SpringContext.getBean(name, Action.class);
        if (action == null) {
            throw new IllegalStateException("Bean不存在");
        }
        return action.doExecute(request, response);
    }
}
