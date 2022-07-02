package com.kh.dao;

import com.kh.dto.StudentDTO;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.awt.image.RescaleOp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Repository
public class StudentDAO {
    public StudentDAO(){
        System.out.println("studentDAO");
    }
    @Autowired
    private BasicDataSource basicDataSource;

    public Connection getConnection() throws Exception {
        return basicDataSource.getConnection();
    }

    public int insert (StudentDTO studentDTO) throws Exception {
        String sql = "insert into student values(seq_stu.nextval,?,?)";
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, studentDTO.getName());
            preparedStatement.setString(2, studentDTO.getMemo());

            return preparedStatement.executeUpdate();
        }
    }

    public ArrayList<StudentDTO> selectAll () throws Exception {
        String sql = "select * from student";
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<StudentDTO> arrayList = new ArrayList<>();
            while(resultSet.next()){
                int no = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String memo = resultSet.getString(3);

                arrayList.add(new StudentDTO(no,name,memo));
            } return arrayList;
        }
    }

    public int delete(int no) throws Exception {
        String sql = "delete from student where no = ?";
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, no);

            return preparedStatement.executeUpdate();
        }
    }

    public int modify(StudentDTO studentDTO) throws  Exception {
        String sql = "update student set memo = ? where no = ?";
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, studentDTO.getMemo());
            preparedStatement.setInt(2, studentDTO.getNo());

            return preparedStatement.executeUpdate();
        }
    }

}
