package kr.ac.jejunu;

import java.sql.*;

/**
 * Created by hyh0408 on 2017. 3. 15..
 */
public class UserDao {

    private JdbcContext jdbcContext;

    public User get(Long id) throws ClassNotFoundException, SQLException {
        String sql = "select * from userinfo where id = ?";
        Object[] params = new Object[]{id};
        return jdbcContext.queryForObject(sql, params);
    }



    public Long add(User user) throws ClassNotFoundException, SQLException {
        String sql = "insert into userinfo(name, password) VALUES (?,?)";
        Object[] params = new Object[]{user.getName(), user.getPassword()};
        return jdbcContext.insert(sql, params);
    }


    public void update(User user) throws ClassNotFoundException, SQLException {
        String sql = "update userinfo set name = ?, password = ? where id = ?";
        Object[] params = new Object[]{user.getName(), user.getPassword(), user.getId()};
        jdbcContext.update(sql, params);
    }

    public void delete(Long id) throws ClassNotFoundException, SQLException {
        String sql = "delete from userinfo where id = ?";
        Object[] params = new Object[]{id};
        jdbcContext.update(sql, params);
    }


    public void setJdbcContext(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }
}
