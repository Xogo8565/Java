package student;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {
    private BasicDataSource basicDataSource = new BasicDataSource();

    public StudentDAO(){
        basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        basicDataSource.setUsername("kh");
        basicDataSource.setPassword("kh");

        basicDataSource.setInitialSize(10);
    }

    public Connection getConnection() throws Exception{
        return basicDataSource.getConnection();
    }

    public int insert(StudentDTO studentDTO) throws Exception {
        String sql = "insert into tbl_student values(seq_std.nextval, ?, ?, ?)";

        try (Connection connection =this.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, studentDTO.getName());
            preparedStatement.setString(2, studentDTO.getPhone());
            preparedStatement.setDate(3, studentDTO.getBirth_date());

            return preparedStatement.executeUpdate();
        }
    }

    public int update(StudentDTO studentDTO) throws Exception {
        String sql = "update tbl_student set name = ? , phone = ?, birth_date = ? where no = ?";

        try (Connection connection = this.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, studentDTO.getName());
            preparedStatement.setString(2, studentDTO.getPhone());
            preparedStatement.setDate(3, studentDTO.getBirth_date());
            preparedStatement.setInt(4, studentDTO.getNo());

            return preparedStatement.executeUpdate();
        }
    }

    public int delete(int no) throws Exception {
        String sql = "delete from tbl_student where no = ?";

        try (Connection connection = this.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, no);

            return preparedStatement.executeUpdate();
        }
    }

    public ArrayList<StudentDTO> selectAll() throws Exception {
        String sql = "select * from tbl_student";


        try (Connection connection = this.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ArrayList<StudentDTO> arrayList = new ArrayList<>();
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int no = rs.getInt(1);
                String name = rs.getString(2);
                String phone = rs.getString(3);
                Date birth_date = rs.getDate(4);

                arrayList.add(new StudentDTO(no, name, phone, birth_date));
            }

            return arrayList;
        }
    }

    public StudentDTO select(int no) throws Exception {

        String sql = "select * from tbl_student where no = ? ";

        try (Connection connection = this.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String name = rs.getString(2);
                String phone = rs.getString(3);
                Date birth_date = rs.getDate(4);

                return new StudentDTO(no, name, phone, birth_date);
            }
            return null;
        }

    }
}
