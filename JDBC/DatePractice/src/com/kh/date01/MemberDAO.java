package com.kh.date01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MemberDAO {
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String username = "kh";
    private String pw = "kh";


    public int insert(MemberDTO memberDTO) throws Exception {
        String sql = "insert into tbl_member values (?,?,to_date(?,'yyyy-mm-dd'))";

        try(Connection connection = DriverManager.getConnection(url,username,pw);
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, memberDTO.getId());
            preparedStatement.setString(2, memberDTO.getPw());
            preparedStatement.setString(3, memberDTO.getBirth_date());

            return preparedStatement.executeUpdate();

        }
    }

    public ArrayList<MemberDTO> selectAll() throws Exception{
        String sql = "select * from tbl_member";

        try(Connection connection = DriverManager.getConnection(url, username, pw);
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<MemberDTO> arrayList = new ArrayList<>();

            while (resultSet.next()){
                String id = resultSet.getString(1);
                String pw = resultSet.getString(2);
                String birth_date = toJavaString(resultSet.getDate(3));

                arrayList.add(new MemberDTO(id, pw, birth_date));
            }
            return arrayList;
        }
    }

    public String toJavaString(java.sql.Date date){
        // oracle date 타입의 데이터를 java 의 string 으로 변환 -> SimpleDateFormat
        // 생성자의 인자값을 String 으로 변환할 때 어떤 형식으로 변환할 것인지 format
        // Oracle 에서 월(MM/mm), 분(mi) 이지만 Java 에서 월(MM), 분(mm)
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // format() -> Oracle Date type 을 String 으로 변환해주는 메서드
        return simpleDateFormat.format(date);

    }
}
