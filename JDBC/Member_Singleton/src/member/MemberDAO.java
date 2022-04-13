package member;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
    private BasicDataSource basicDataSource = new BasicDataSource();
    private static MemberDAO instance = null;

    private MemberDAO() {
        basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        basicDataSource.setUsername("kh");
        basicDataSource.setPassword("kh");
        basicDataSource.setInitialSize(10);
    }

    public static MemberDAO getInstance() {
        if (instance == null) {
            instance = new MemberDAO();
        }
        return instance;
    }

    public Connection getConnection() throws Exception {
        return basicDataSource.getConnection();
    }

    public boolean doesIdExist(String id) throws Exception {
        String sql = "select * from tbl_member where id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        }
    }

    public MemberDTO login(MemberDTO memberDTO) throws Exception {
        String sql = "select * from tbl_member where id = ? and  pw = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, memberDTO.getId());
            preparedStatement.setString(2, memberDTO.getPw());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String nickname = resultSet.getString(3);
                return new MemberDTO(memberDTO.getId(), memberDTO.getPw(), nickname);
            }
            return null;
        }
    }

    public int addMember(MemberDTO memberDTO) throws Exception {
        String sql = "insert into tbl_member values (?,?,?)";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1, memberDTO.getId());
            preparedStatement.setString(2, memberDTO.getPw());
            preparedStatement.setString(3, memberDTO.getNickname());

            return preparedStatement.executeUpdate();
        }
    }

    public void deleteMember(MemberDTO memberDTO) throws Exception {
        String sql = "delete from tbl_member where id = ? and pw =?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1, memberDTO.getId());
            preparedStatement.setString(2, memberDTO.getPw());

            preparedStatement.executeUpdate();
        }
    }

}
