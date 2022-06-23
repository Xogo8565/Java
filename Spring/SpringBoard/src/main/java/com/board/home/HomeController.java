package com.board.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.*;

@Controller
public class HomeController {
    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/")
    public String home(){
        logger.info("Home 요청");
        return "home";
    }

    @RequestMapping(value = "/toError")
    public String toError() {
        return  "error";
    }
}
