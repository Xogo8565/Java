package com.kh.controller;

import com.kh.dao.StudentDAO;
import com.kh.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.*;
import java.util.ArrayList;

@Controller(value = "*.stu2")
public class StudentController2 extends HttpServlet {
    @Autowired
    private StudentDAO studentDAO;

    @RequestMapping(value =  "/toOutput.stu2")
    public String output2() {
        return "output2";
    }

    @ResponseBody
    @RequestMapping("/output.stu2")
    public ArrayList<StudentDTO> outputAjax() throws Exception {
        return studentDAO.selectAll();
    }

    @ResponseBody
    @RequestMapping("/modify.stu2")
    public String modifyAjax(StudentDTO studentDTO) throws Exception {
        int rs = studentDAO.modify(studentDTO);
        if(rs>0) return "success";
        else return "fail";
    }

    @ResponseBody
    @RequestMapping("/delete.stu2")
    public String deleteAjax(int no) throws Exception{
        int rs = studentDAO.delete(no);
        if(rs>0) return "success";
        else return "fail";
    }
}
