package com.message.dao;

import com.message.dto.MessageDTO;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//@Repository : DB에 직접적으로 데이터를 전달/ 수정/ 삭제/ 조회하는 클래스에 붙여주는 어노테이션
@Repository
public class MessageDAO {

    /*
    * root-context.xml -> BasicDataSource 형 인스턴스가 생성
    * MessageDAO 형 인스턴스 생성(생성될 당시에는 bds라는 멤버 필드는 null
    * @Autowired 달려 있는 멤버 필드는 스프링 컨테이너 안에서 해당 자료형의 인스턴스를 찾아서 그 멥버 필드에 값을 세팅해주는 작업을 알아서 해주는 어노테이션
    * */
    @Autowired
    @Qualifier("basicDataSource")
    private BasicDataSource basicDataSource;

    public MessageDAO() {
        System.out.println("MessageDAO");
    }

    public int insert(MessageDTO messageDTO) throws Exception {
        String sql = "insert into tbl_msg values(seq_msg.nextval,?,?)";
        try(Connection connection = basicDataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, messageDTO.getNickname());
            preparedStatement.setString(2, messageDTO.getMessage());

            return preparedStatement.executeUpdate();
        }
    }

    public ArrayList<MessageDTO> selectAll() throws Exception {
        String sql = "select * from tbl_msg";
        try(Connection connection = basicDataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<MessageDTO> arrayList = new ArrayList<>();

            while(resultSet.next()){
                int seq_msg = resultSet.getInt(1);
                String nickname = resultSet.getString(2);
                String message = resultSet.getString(3);
                arrayList.add(new MessageDTO(seq_msg, nickname, message));
            } return arrayList;
        }
    }
    public int delete(int seq_msg) throws Exception {
        String sql = "delete from tbl_msg where no = ?";
        try(Connection connection = basicDataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, seq_msg);

            return preparedStatement.executeUpdate();
        }
    }

    public int modify(MessageDTO messageDTO) throws Exception {
        String sql = "update tbl_msg set message = ? where no = ?";
        try(Connection connection = basicDataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, messageDTO.getMessage());
            preparedStatement.setInt(2, messageDTO.getSeq_msg());

            return preparedStatement.executeUpdate();
        }
    }
}
