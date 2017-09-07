package com.company.project.adminweb.pattern.action;

import com.company.common.json.Jsons;
import com.company.project.adminweb.support.Results;
import com.company.project.adminweb.support.context.SessionUserInfo;
import com.company.project.adminweb.support.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.invoke.MethodHandles;
import java.util.Map;

/**
 * 基础Action
 *
 * @author wangzhj
 */
public abstract class BaseAction implements Action {

    protected static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public final Map<String, Object> doExecute(HttpServletRequest request, HttpServletResponse response) {

        LOGGER.info("ParameterMap===>" + request.getParameterMap());
        Map<String, Object> result;
        try {
            //参数
            Map<String, Object> param = request.getParameterMap();
            LOGGER.info("===> i: {}", Jsons.toJson(param));
            //包装
            SessionUserInfo userInfo = null;
            RequestContext cxt = new RequestContext(request, response, userInfo);
            //验证
            checkData(cxt, param);
            //执行
            Map<String, Object> data = execute(cxt, param);
            //结果
            result = Results.ok(data);
            LOGGER.info("<=== o: {}", Jsons.toJson(result));
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

    /**
     * 验证参数
     *
     * @param cxt
     * @param param
     */
    public abstract void checkData(RequestContext cxt, Map<String, Object> param);

    /**
     * 执行逻辑
     *
     * @param cxt
     * @param param
     * @return Map<String, Object>
     */
    public abstract Map<String, Object> execute(RequestContext cxt, Map<String, Object> param);
}
