package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertUserStatementStrategy implements StatementStrategy {
    private User user;

    public InsertUserStatementStrategy(User user) {
        this.user = user;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into userinfo(name, password) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());
        return preparedStatement;
    }
}
