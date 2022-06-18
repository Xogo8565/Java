package com.kh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.*;

@ControllerAdvice
public class ControlAdvice extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(ControlAdvice.class);

    @ExceptionHandler
    public String ExceptionHandler(Exception e){
        e.printStackTrace();
        return "redirect:/toError";
    }
}
