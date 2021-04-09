package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStatementStrategy implements StatementStrategy {
    private Integer id;
    public DeleteStatementStrategy(Integer id) {
        this.id = id;
    }
    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(
                "delete from userinfo where id = ?"
        );
        preparedStatement.setInt(1, id);
        return preparedStatement;
    }
}
