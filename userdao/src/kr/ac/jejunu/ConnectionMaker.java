package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by hyh0408 on 2017. 3. 24..
 */
public interface ConnectionMaker {
    public Connection getConnection() throws ClassNotFoundException, SQLException;
}
