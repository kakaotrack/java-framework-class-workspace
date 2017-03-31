package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by hyh0408 on 2017. 3. 31..
 */
public class UpdateUserStatementStrategy implements StatementStrategy {
    @Override
    public PreparedStatement makeStatement(Object object, Connection connection) throws SQLException {
        User user = (User) object;
        PreparedStatement preparedStatement = connection.prepareStatement("update userinfo set name = ?, password = ? where id = ?");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setLong(3, user.getId());
        return preparedStatement;
    }
}
