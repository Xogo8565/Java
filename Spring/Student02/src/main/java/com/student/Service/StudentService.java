package com.student.Service;

import com.student.dao.StudentDAO;
import com.student.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentDAO studentDAO;

    public void insert(StudentDTO studentDTO) throws Exception {
        studentDAO.insert(studentDTO);
    }

    public void update(StudentDTO studentDTO) throws Exception {
        studentDAO.update(studentDTO);
    }

    public void delete(int no) throws Exception {
        studentDAO.delete(no);
    }

    public List<StudentDTO> selectList() throws Exception{
        return studentDAO.selectList();
    }

    public void delete(int[] no) {
        studentDAO.delete(no);
    }
}
