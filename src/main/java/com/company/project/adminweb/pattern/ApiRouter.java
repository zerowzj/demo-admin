package com.company.project.adminweb.pattern;

import com.company.project.adminweb.pattern.action.ActionExecutor;
import com.company.project.adminweb.support.annotation.Action;
import com.company.project.adminweb.support.annotation.Api;
import com.google.common.base.Joiner;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by wangzhj on 2017/9/6.
 */
@Api
public class ApiRouter {

    private static final String ACTION_PREFIX = "action";

    @Action("/{module}/{action}")
    public Map<String, Object> router(@PathVariable String module, @PathVariable String action,
                                      HttpServletRequest request, HttpServletResponse response) {
        String actionName = Joiner.on("_").join(ACTION_PREFIX, module, action);
        return ActionExecutor.execute(request, response, actionName);
    }
}
