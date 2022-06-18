package com.kh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

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
