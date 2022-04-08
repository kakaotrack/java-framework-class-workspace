package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStatementStrategy implements StatementStrategy {
    @Override
    public PreparedStatement makeStatement(Object obj, Connection connection) throws SQLException {
        Integer id = (Integer) obj;
        PreparedStatement preparedStatement = connection.prepareStatement(
                "delete from userinfo where id = ?"
        );
        preparedStatement.setInt(1, id);
        return preparedStatement;

    }
}
