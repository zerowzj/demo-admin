package com.company.project.adminweb.web.api.demo;

import com.company.exception.entity.param.EmptyValueException;
import com.company.project.adminweb.pattern.action.BaseAction;
import com.company.project.adminweb.support.context.RequestContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by wangzhj on 2017/8/10.
 */
@Component
public class Action_say_hi extends BaseAction {

    @Override
    public void checkData(RequestContext cxt, Map<String, Object> param) {
        LOGGER.info("sdfsfsdf");
        throw new EmptyValueException("ABC");
    }

    @Override
    public Map<String, Object> execute(RequestContext cxt, Map<String, Object> param) {
        return null;
    }
}
