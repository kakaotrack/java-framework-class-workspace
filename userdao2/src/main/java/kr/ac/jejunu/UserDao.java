package kr.ac.jejunu;

import java.sql.*;

public class UserDao {
    public User findById(Integer id) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        //sql 작성
        PreparedStatement preparedStatement =
                connection.prepareStatement(
                        "select * from userinfo where id = ?"
                );
        preparedStatement.setInt(1, id);
        //sql 실행
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        //User 에 데이터 매핑
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        //자원 해지
        resultSet.close();
        preparedStatement.close();
        connection.close();
        //User 리턴
        return user;
    }


    public void insert(User user) throws ClassNotFoundException, SQLException {
        //드라이버 로딩
        Connection connection = getConnection();
        //sql 작성
        PreparedStatement preparedStatement =
                connection.prepareStatement(
                        "insert into userinfo(name, password) values ( ?, ? )"
                        ,Statement.RETURN_GENERATED_KEYS
                );
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());
        //sql 실행
        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        resultSet.next();
        //User 에 데이터 매핑
        user.setId(resultSet.getInt(1));
        //자원 해지
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }


    private Connection getConnection() throws ClassNotFoundException, SQLException {
        //드라이버 로딩
        Class.forName("com.mysql.cj.jdbc.Driver");
        //커넥션
        return DriverManager.getConnection(
                "jdbc:mysql://192.168.151.176:3306/jeju?serverTimezone=UTC",
                "jeju",
                "jejupw"
        );
    }
}



