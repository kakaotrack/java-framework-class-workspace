package kr.ac.jejunu.userdao;

import java.sql.*;

public class UserDao {
    public User get(Long id) throws ClassNotFoundException, SQLException {
        //DB 가 뭐야? mysql
        //어딨어? 알려주께..
        //드라이버 로드
        Class.forName("com.mysql.cj.jdbc.Driver");
        //커넥션 맺고
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost/jeju?serverTimezone=UTC"
                , "jeju", "jejupw");
        //SQL 쿼리 만들고
        PreparedStatement preparedStatement =
                connection.prepareStatement("select * from userinfo where id = ?");
        preparedStatement.setLong(1, id);

        //쿼리 실행하고
        ResultSet resultSet = preparedStatement.executeQuery();
        //실행된 쿼리를 오브젝트에 매핑하고
        resultSet.next();
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        //자원 해지하고
        resultSet.close();
        preparedStatement.close();
        connection.close();
        //리턴
        return user;
    }
}
