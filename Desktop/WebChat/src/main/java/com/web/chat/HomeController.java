package com.web.chat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    HomeController() {
        System.out.println("home");
    }
    @GetMapping("/")
    public String toHome() throws Exception {
        return "home";
    }
}
