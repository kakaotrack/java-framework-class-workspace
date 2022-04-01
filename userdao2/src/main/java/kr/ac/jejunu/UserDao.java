package kr.ac.jejunu;

import javax.sql.DataSource;
import java.sql.*;

public class UserDao {
    private final DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public User findById(Integer id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            connection = dataSource.getConnection();
            //sql 작성
            preparedStatement = connection.prepareStatement(
                    "select * from userinfo where id = ?"
            );
            preparedStatement.setInt(1, id);
            //sql 실행
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                //User 에 데이터 매핑
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
            }
        } finally {
            try {
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return user;
    }


    public void insert(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //드라이버 로딩
            connection = dataSource.getConnection();
            //sql 작성
            preparedStatement = connection.prepareStatement(
                    "insert into userinfo(name, password) values ( ?, ? )"
                    , Statement.RETURN_GENERATED_KEYS
            );
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            //sql 실행
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            //User 에 데이터 매핑
            user.setId(resultSet.getInt(1));
        } finally {
            try {
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //자원 해지
    }


    public void update(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //드라이버 로딩
            connection = dataSource.getConnection();
            //sql 작성
            preparedStatement = connection.prepareStatement(
                    "update userinfo set name = ?, password = ? where id = ?"
            );
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getId());
            //sql 실행
            preparedStatement.executeUpdate();
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(Integer id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //드라이버 로딩
            connection = dataSource.getConnection();
            //sql 작성
            preparedStatement = connection.prepareStatement(
                    "delete from userinfo where id = ?"
            );
            preparedStatement.setInt(1, id);
            //sql 실행
            preparedStatement.executeUpdate();
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}



