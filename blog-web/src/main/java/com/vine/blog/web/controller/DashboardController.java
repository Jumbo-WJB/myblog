package com.vine.blog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

    @RequestMapping("/")
    public String index() {
        return "dashboard";
    }


    @RequestMapping("/tool/index")
    public String tool() {
        return "table";
    }




}
