package kr.ac.jejunu;

import java.sql.*;

/**
 * Created by hyh0408 on 2017. 3. 15..
 */
public class UserDao {
    public User get(Long id) throws ClassNotFoundException, SQLException {
        //User 어디에있어? Mysql
        //Class 를 로딩해야되겠네.
        Class.forName("com.mysql.jdbc.Driver");
        //커넥션을 맺기
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/jeju", "jeju", "jejupw");
        //쿼리를만들어야겠네
        PreparedStatement preparedStatement = connection.prepareStatement("select * from userinfo where id = ?");
        preparedStatement.setLong(1, id);
        //쿼리를실행해야겠네
        ResultSet resultSet = preparedStatement.executeQuery();
        //실행된결과를 객체에매핑
        resultSet.next();
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        //자원해지
        resultSet.close();
        preparedStatement.close();
        connection.close();
        //결과를 리턴
        return user;
    }
}
