package kr.ac.jejunu.userdao;

import java.sql.*;

public class UserDao {
    public User get(Integer id) throws ClassNotFoundException, SQLException {
        //DB는 뭐래?
        //Mysql 이래.
        //Driver 로드하고
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Connection 맺고
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/jeju?serverTimezone=Asia/Seoul", "jeju", "jejupw");
        //Query 만들고
        PreparedStatement statement = connection.prepareStatement("select * from userinfo where id = ?");
        statement.setInt(1, id);
        //Query 실행하고
        ResultSet resultSet = statement.executeQuery();
        //결과값 매핑하고
        resultSet.next();
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        //자원 해지하고
        resultSet.close();
        statement.close();
        connection.close();
        //리턴
        return user;
    }
}
