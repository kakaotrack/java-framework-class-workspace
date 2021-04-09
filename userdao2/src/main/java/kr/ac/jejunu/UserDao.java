package kr.ac.jejunu;

import javax.sql.DataSource;
import java.sql.*;

public class UserDao {
    private final JdbcContext jdbcContext;

    public UserDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public User findById(Integer id) throws SQLException {
        //데이터 어딨어? => mysql
        StatementStrategy statementStrategy = new FindByIdStatementStrategy(id);
        return jdbcContext.jdbcContextForFindById(statementStrategy);
    }


    public void insert(User user) throws SQLException {
        //데이터 어딨어? => mysql
        StatementStrategy statementStrategy = new InsertStatementStrategy(user);
        jdbcContext.jdbcContextForInsert(user, statementStrategy);

    }
    public void update(User user) throws SQLException {
        //데이터 어딨어? => mysql
        StatementStrategy statementStrategy = new UpdateStatementStrategy(user);
        jdbcContext.jdbcContextForUpdate(statementStrategy);

    }

    public void delete(Integer id) throws SQLException {
        //데이터 어딨어? => mysql
        StatementStrategy statementStrategy = new DeleteStatementStrategy(id);
        jdbcContext.jdbcContextForUpdate(statementStrategy);

    }


}






