package com.board.error;

import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.*;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice extends HttpServlet {
    @ExceptionHandler
    public String ExceptionHandler(Exception e){
        e.printStackTrace();
        return "redirect:/toError";
    }
}
