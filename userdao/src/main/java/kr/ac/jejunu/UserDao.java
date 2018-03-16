package kr.ac.jejunu;

import java.sql.*;

public class UserDao {
    public User get(int id) throws ClassNotFoundException, SQLException {
        //mysql driver load
        Class.forName("com.mysql.jdbc.Driver");
        //Connection 맺고
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/jeju"
                , "jeju", "jejupw");
        //sql 작성하고
        PreparedStatement preparedStatement =
                connection.prepareStatement("select * from userinfo where id = ?");
        preparedStatement.setInt(1, id);
        //sql 실행하고
        ResultSet resultSet = preparedStatement.executeQuery();
        //결과를 User 에 매핑하고
        resultSet.next();
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        //자원을 해지하고
        resultSet.close();
        preparedStatement.close();
        connection.close();
        //결과를 리턴한다.
        return user;
    }
}
