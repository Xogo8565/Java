package com.kh.controller;

import com.kh.dao.StudentDAO;
import com.kh.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.*;
import java.util.ArrayList;

@Controller(value = "*.stu")
public class StudentController extends HttpServlet {
    @Autowired
    private StudentDAO studentDAO;

    @RequestMapping(value = "/toInput.stu")
    public String toInput() {
        return "input";
    }

    @RequestMapping(value = "/input.stu")
    public String input(StudentDTO studentDTO) throws Exception {

        studentDAO.insert(studentDTO);
        return "redirect:/";
    }

    @RequestMapping(value = "/toOutput.stu")
    public String toOutput(Model model) throws Exception {
        ArrayList<StudentDTO> arrayList = studentDAO.selectAll();
        model.addAttribute("arrayList", arrayList);
        return "output";

    }

    @RequestMapping(value = "/delete.stu")
    public String delete(int no) throws Exception {

        studentDAO.delete(no);
        return "redirect:/toOutput.stu";

    }

    @RequestMapping(value = "/modify.stu")
    public String modify(StudentDTO studentDTO) throws Exception {

        studentDAO.modify(studentDTO);
        return "redirect:/toOutput.stu";

    }

}
