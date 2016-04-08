package kr.ac.jejunu.userdao;

import java.sql.*;

/**
 * Created by hyh0408 on 2016. 3. 22..
 */
public class UserDao {

    private JdbcContext jdbcContext;

    public UserDao() {

    }

    public User get(Long id) throws SQLException {

        User user = jdbcContext.jdbcContextWithStatementStrategyForSelect((Connection connection) -> {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from userinfo where id = ?");
            preparedStatement.setLong(1, id);
            return preparedStatement;
        });
        return user;
    }


    public Long add(User user) throws ClassNotFoundException, SQLException {
        Long id = jdbcContext.jdbcContextWithStatementStrategyForInsert((Connection connection) -> {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into userinfo(name, password) values (?, ?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            return preparedStatement;
        });
        return id;
    }

    public void delete(Long id) throws SQLException {
        jdbcContext.jdbcContextWithStatementStrategyForUpdate((Connection connection) -> {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from userinfo where id = ?");
            preparedStatement.setLong(1, id);
            return preparedStatement;
        });
    }


    public void update(User user) throws SQLException {
        jdbcContext.jdbcContextWithStatementStrategyForUpdate((Connection connection) -> {
            PreparedStatement preparedStatement = connection.prepareStatement("update userinfo set name=?, password=? where id = ?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setLong(3, user.getId());

            return preparedStatement;
        });
    }


    public void setJdbcContext(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }
}
