package com.kh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.*;


@Controller
public class HomeController extends HttpServlet {
    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping("/toError")
    public String Error(){
        return "error";
    }
}
