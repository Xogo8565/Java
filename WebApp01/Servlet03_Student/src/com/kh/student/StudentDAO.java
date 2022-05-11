package com.kh.student;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDAO {

    private BasicDataSource basicDataSource;

    public StudentDAO() {
        // 서버에 이미 생성된 ConnectionPoll 을 찾는 작업
        try {
            Context context = new InitialContext(); // ConnectionPool 을 검색하기 위한 인스턴스 생성
            Context envContext = (Context)context.lookup("java:comp/env"); //자원이 실제 존재하는 위치까지 찾아가는 작업
            basicDataSource = (BasicDataSource) envContext.lookup("jdbc/bds"); // 자원의 name 값을 이용해 이미 만들어진 bds 인스턴스 가져오기
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws Exception {
        return basicDataSource.getConnection();
    }

    public int insert(StudentDTO studentDTO) throws Exception {
        String sql = "insert into tbl_stu values(seq_stu.nextval,?,?,?,?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, studentDTO.getName());
            preparedStatement.setInt(2, studentDTO.getKor());
            preparedStatement.setInt(3, studentDTO.getEng());
            preparedStatement.setInt(4, studentDTO.getMath());

            return preparedStatement.executeUpdate();
        }
    }

    public ArrayList<StudentDTO> selectAll() throws Exception {
        String sql = "select * from tbl_stu";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<StudentDTO> arrayList = new ArrayList<>();
            while (resultSet.next()) {
                int no = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int kor = resultSet.getInt(3);
                int eng = resultSet.getInt(4);
                int math = resultSet.getInt(5);

                arrayList.add(new StudentDTO(no, name, kor, eng, math));
            }

            return arrayList;
        }
    }

    public int delete(int no) throws Exception {
        String sql = "delete from tbl_stu where no = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, no);

            return preparedStatement.executeUpdate();
        }
    }

    public int update(StudentDTO studentDTO) throws Exception {
        String sql = "update tbl_stu set name = ?, kor = ?, eng = ?, math =? where no =?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, studentDTO.getName());
            preparedStatement.setInt(2, studentDTO.getKor());
            preparedStatement.setInt(3, studentDTO.getEng());
            preparedStatement.setInt(4, studentDTO.getMath());
            preparedStatement.setInt(5, studentDTO.getNo());

            return preparedStatement.executeUpdate();
        }
    }

    public StudentDTO select(int no) throws Exception {
        String sql = "select * from tbl_stu where no = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, no);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new StudentDTO(no, rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
            }
            return null;
        }
    }
}
