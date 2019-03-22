package kr.ac.jejunu.userdao;

import java.sql.*;

public class UserDao {
    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public User get(Long id) throws ClassNotFoundException, SQLException {
        Connection connection = connectionMaker.getConnection();

        PreparedStatement statement = connection.prepareStatement("select * from userinfo where id = ?");
        statement.setLong(1, id);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        resultSet.close();
        statement.close();
        connection.close();

        return user;
    }


    public Long add(User user) throws SQLException, ClassNotFoundException {
        Connection connection = connectionMaker.getConnection();

        PreparedStatement statement = connection.prepareStatement("insert into userinfo(name, password) values (?, ?)");
        statement.setString(1, user.getName());
        statement.setString(2, user.getPassword());
        statement.executeUpdate();

        statement = connection.prepareStatement("select last_insert_id()");
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        Long id = resultSet.getLong(1);

        resultSet.close();
        statement.close();
        connection.close();

        return id;
    }
}
