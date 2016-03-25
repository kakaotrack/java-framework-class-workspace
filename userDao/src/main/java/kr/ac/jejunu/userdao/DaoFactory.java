package kr.ac.jejunu.userdao;

import com.mysql.jdbc.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

/**
 * Created by hyh0408 on 2016. 3. 23..
 */
@Configuration
public class DaoFactory {
    @Bean
    public UserDao userDao() {
        UserDao userDao = new UserDao();
        userDao.setDataSource(dataSource());
        return userDao;
    }

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost/jeju?characterEncoding=utf-8");
        dataSource.setUsername(System.getenv("DATABASE_USERNAME"));
        dataSource.setPassword(System.getenv("DATABASE_PASSWORD"));
        return dataSource;
    }
}
