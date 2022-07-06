package com.student.dao;

import com.student.dto.StudentDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAO {

    @Autowired
    private SqlSession session;

    public List<StudentDTO> selectList() throws Exception {
        return session.selectList("studentMapper.selectList");
    }

    public void insert(StudentDTO studentDTO) {
        session.insert("studentMapper.insert", studentDTO);
    }

    public void update(StudentDTO studentDTO) {
        session.update("studentMapper.update", studentDTO);
    }

    public void delete(int no) {
        session.delete("studentMapper.delete", no);
    }

    public void delete(int[] no) {
        session.delete("studentMapper.del", no);
    }
}
