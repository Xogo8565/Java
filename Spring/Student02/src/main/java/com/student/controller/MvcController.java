package com.student.controller;

import com.student.Service.StudentService;
import com.student.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class MvcController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/")
    public String home() {
        return "home";
    }

    @GetMapping("/toError")
    public String Error() {
        return "error";
    }

    @GetMapping("/input")
    public String toInput() {
        return "input";
    }

    @GetMapping("/output")
    public String output(Model model) throws Exception {
        List<StudentDTO> list = studentService.selectList();
        model.addAttribute("list", list);

        return "output";
    }
}
