package kr.ac.jejunu.userdao;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by hyh0408 on 2016. 3. 22..
 */
public class UserDao {

    private JdbcContext jdbcContext;

    public UserDao() {

    }

    public User get(Long id) throws SQLException {

        StatementStrategy statementStrategy = new GetUserStatementStrategy(id);
        User user = jdbcContext.jdbcContextWithStatementStrategyForSelect(statementStrategy);
        return user;
    }


    public Long add(User user) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new AddUserStatementStrategy(user);
        Long id = jdbcContext.jdbcContextWithStatementStrategyForInsert(statementStrategy);
        return id;
    }

    public void delete(Long id) {
        StatementStrategy statementStrategy = new DeleteUserStatementStrategy(id);
        jdbcContext.jdbcContextWithStatementStrategyForUpdate(statementStrategy);
    }


    public void update(User user) {
        StatementStrategy statementStrategy = new UpdateUserStatementStrategy(user);
        jdbcContext.jdbcContextWithStatementStrategyForUpdate(statementStrategy);
    }


    public void setJdbcContext(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }
}
