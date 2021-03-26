package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HallaUserDao extends UserDao {
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost/jeju?" +
                        "characterEncoding=utf-8&serverTimezone=UTC"
                , "jeju", "jejupw"
        );
    }
}
