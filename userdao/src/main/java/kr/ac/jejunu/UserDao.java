package kr.ac.jejunu;

import java.sql.*;

public class UserDao {
    public User get(Integer id) throws ClassNotFoundException, SQLException {
        //데이터는 어디에저장되어있어? => mysql
        //접속정보줘 => localhost/jeju?charecterEncoding=utf-8&serverTimezone=UTC
        //user=jeju password=jejupw
        //드라이버 로드
        Class.forName("com.mysql.cj.jdbc.Driver");
        //커넥션맺고
        Connection connection =
                DriverManager.getConnection(
                        "jdbc:mysql://localhost/jeju?characterEncoding=utf-8&serverTimezone=UTC"
                ,"jeju","jejupw");
        //쿼리만들고
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from userinfo where id = ?"
        );
        preparedStatement.setInt(1, id);
        //쿼리실행하고
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        //데이터를 오브젝트로 매핑
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        //자원해제
        resultSet.close();
        preparedStatement.close();
        connection.close();
        //return
        return user;
    }
}
