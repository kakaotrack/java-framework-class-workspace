package kr.ac.jejunu;

import javax.sql.DataSource;
import java.sql.*;

public class UserDao {
    private final DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public User findById(Integer id) throws SQLException {
        //데이터 어딨어? => mysql
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            connection = dataSource.getConnection();
            StatementStrategy statementStrategy = new FindByIdStatementStrategy();
            preparedStatement = statementStrategy.makeStatement(id, connection);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
            }
        } finally {
            try {
                resultSet.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
            try {
                connection.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }
        return user;
    }

    public void insert(User user) throws SQLException {
        //데이터 어딨어? => mysql
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            StatementStrategy statementStrategy = new InsertStatementStrategy();
            preparedStatement = statementStrategy.makeStatement(user, connection);

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            user.setId(resultSet.getInt(1));
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
            try {
                connection.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public void update(User user) throws SQLException {
        //데이터 어딨어? => mysql
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            StatementStrategy statementStrategy = new UpdateStatementStrategy();
            preparedStatement = statementStrategy.makeStatement(user, connection);

            preparedStatement.executeUpdate();
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
            try {
                connection.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public void delete(Integer id) throws SQLException {
        //데이터 어딨어? => mysql
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            StatementStrategy statementStrategy = new DeleteStatementStrategy();
            preparedStatement = statementStrategy.makeStatement(id, connection);

            preparedStatement.executeUpdate();
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
            try {
                connection.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }

    }

//    abstract private PreparedStatement makeStatement(Integer id, Connection connection) throws SQLException;

//    }
}






