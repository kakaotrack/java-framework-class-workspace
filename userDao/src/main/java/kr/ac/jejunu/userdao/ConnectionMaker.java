package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by hyh0408 on 2016. 3. 23..
 */
public interface ConnectionMaker {
    Connection getConnection() throws ClassNotFoundException, SQLException;
}
