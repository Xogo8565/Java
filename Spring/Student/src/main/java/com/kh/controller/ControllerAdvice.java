package com.kh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.*;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);

    @ExceptionHandler
    public String ExceptionHandler(Exception e){
        e.printStackTrace();
        return "redirect:/toError";
    }
}
