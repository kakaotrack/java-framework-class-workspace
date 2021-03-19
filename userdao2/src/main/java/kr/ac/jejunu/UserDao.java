package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.DriverManager;

public class UserDao {
    public User findById(Integer id) {
        //데이터 어딨어? => mysql
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection =
                DriverManager.getConnection(
                        "jdbc:mysql://localhost/jeju?" +
                                "characterEncoding=utf-8&serverTimezone=UTC"
                        ,"jeju","jejupw"
                );
    }
}
