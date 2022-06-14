package com.kh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@Controller
public class HomeController extends HttpServlet {
    public  HomeController(){
        System.out.println("HomeController On");
    }
    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }
    @RequestMapping(value = "/test")
    public String test() {
        return "test";
    }
    @RequestMapping(value = "/test2")
    public String test2(){
        return "/temp/test2";
    }
}
