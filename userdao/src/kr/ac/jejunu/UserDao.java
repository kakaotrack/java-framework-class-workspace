package kr.ac.jejunu;

import java.sql.*;

public class UserDao {
    public User findById(Integer id) throws ClassNotFoundException, SQLException {
        //데이터는 어디에 있나요? 어떤 DB 요? Mysql
        //Mysql 드라이버 로딩
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Connection 을 맺고
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/jeju"
                        , "jeju", "jejupw");
        //Sql 을 만들고
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from userinfo where id = ?"
        );
        preparedStatement.setInt(1, id);
        //SQl 을 실행하고
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        //결과를 User 에 잘 매핑하고
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
