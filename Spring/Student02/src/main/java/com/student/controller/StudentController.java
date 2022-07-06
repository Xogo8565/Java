package com.student.controller;


import com.student.Service.StudentService;
import com.student.dto.StudentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/input")
    public String input(StudentDTO studentDTO) throws Exception {
        studentService.insert(studentDTO);
        return "redirect:/";
    }

    @PutMapping("/output")
    public String update(StudentDTO studentDTO) throws Exception {
        studentService.update(studentDTO);
        return "redirect:/output";
    }

//    @DeleteMapping("/output/{no}")
//    public String delete(@PathVariable(value="no") int no) throws Exception {
//        studentService.delete(no);
//        return "redirect:/output";
//    }

    @DeleteMapping("/output")
    public void delete(@RequestParam(value = "no[]") int[] no) throws Exception {
        studentService.delete(no);
    }

}
