package com.company.project.adminweb.web.controller.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangzhj on 2017/8/18.
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/to_add")
    public String tt(){
        return "/demo/add";
    }
}
