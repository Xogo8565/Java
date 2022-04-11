package com.kh.student;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String username = "kh";
    private String pw = "kh";

    public int insert(StudentDTO studentDTO) throws Exception {
        try (Connection connection = DriverManager.getConnection(url, username, pw);
             Statement stm = connection.createStatement();) {

            String sql = "Insert into tbl_student values(seq_std.nextval, '" +
                    studentDTO.getName() + "','" +
                    studentDTO.getPhone() + "','" +
                    studentDTO.getBirth_date() + "')";

            return stm.executeUpdate(sql);
        }
    }

    public int update(StudentDTO studentDTO) throws Exception {
        try (Connection connection = DriverManager.getConnection(url, username, pw);
             Statement stm = connection.createStatement();) {

            String sql = "update tbl_student set name = '" + studentDTO.getName() + "', " +
                    "phone = '" + studentDTO.getPhone() + "', " +
                    "birth_date = '" + studentDTO.getBirth_date() + "' where no =" + studentDTO.getNo();

            return stm.executeUpdate(sql);
        }
    }

    public int delete(int no) throws Exception {
        try (Connection connection = DriverManager.getConnection(url, username, pw);
             Statement stm = connection.createStatement();) {

            String sql = "delete from tbl_student where no = " + no;

            return stm.executeUpdate(sql);
        }
    }

    public ArrayList<StudentDTO> selectAll() throws Exception{
        try (Connection connection = DriverManager.getConnection(url,username,pw);
        Statement stm = connection.createStatement();){

            String sql = "select * from tbl_student";
            ArrayList<StudentDTO> arrayList = new ArrayList<>();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()){
                int no = rs.getInt(1);
                String name = rs.getString(2);
                String phone = rs.getString(3);
                Date birth_date = rs.getDate(4);

                arrayList.add(new StudentDTO(no,name,phone,birth_date));
            }

            return  arrayList;
        }
    }

    public StudentDTO select(int no) throws Exception {
        try(Connection connection = DriverManager.getConnection(url,username,pw);
        Statement stm = connection.createStatement()){

            String sql = "select * from tbl_student where no = " + no;
            ResultSet rs = stm.executeQuery(sql);

            if(rs.next()){
                String name = rs.getString(2);
                String phone = rs.getString(3);
                Date birth_date = rs.getDate(4);

                return new StudentDTO(no,name,phone,birth_date);
            }
            return null;
        }

    }
}
