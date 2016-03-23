package kr.ac.jejunu.userdao;

import java.sql.*;

/**
 * Created by hyh0408 on 2016. 3. 22..
 */
public class UserDao {

    private final ConnectionMaker connectionMaker;

    public UserDao() {
        this.connectionMaker = new JejuConnectionMaker();
    }

    public User get(Long id) throws ClassNotFoundException, SQLException {
        Connection connection = connectionMaker.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("select * from userinfo where id = ?");
        preparedStatement.setLong(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return user;
    }

    public Long add(User user) throws ClassNotFoundException, SQLException {
        Connection connection = connectionMaker.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("insert into userinfo(name, password) values (?, ?)");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());

        preparedStatement.executeUpdate();

        Long id = getLastInsertId(connection);

        preparedStatement.close();
        connection.close();

        return id;
    }


    private Long getLastInsertId(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select last_insert_id()");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        Long id = resultSet.getLong(1);
        resultSet.close();
        return id;
    }

}
