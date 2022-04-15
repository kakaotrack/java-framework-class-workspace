package kr.ac.jejunu;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserDaoTests {
    private static UserDao userDao;

    @BeforeAll
    public static void setup() throws ClassNotFoundException {
//        ApplicationContext applicationContext
//        = new AnnotationConfigApplicationContext(DaoFactory.class);
//        StaticApplicationContext applicationContext = new StaticApplicationContext();
//        BeanDefinition dataBeanDefinition = new RootBeanDefinition(SimpleDriverDataSource.class);
//        dataBeanDefinition.getPropertyValues()
//                        .addPropertyValue("driverClass"
//                                , System.getenv("DB_DRIVERNAME"));
//        dataBeanDefinition.getPropertyValues()
//                .addPropertyValue("url"
//                        , System.getenv("DB_URL"));
//        dataBeanDefinition.getPropertyValues()
//                .addPropertyValue("username"
//                        , System.getenv("DB_USERNAME"));
//        dataBeanDefinition.getPropertyValues()
//                .addPropertyValue("password"
//                        , System.getenv("DB_PASSWORD"));
//
//
//        applicationContext.registerBeanDefinition("dataSource", dataBeanDefinition);
//        BeanDefinition jdbcBeanDefinition = new RootBeanDefinition(JdbcTemplate.class);
//        jdbcBeanDefinition.getConstructorArgumentValues()
//                        .addGenericArgumentValue(new RuntimeBeanReference("dataSource"));
//        applicationContext.registerBeanDefinition("jdbcTemplate", jdbcBeanDefinition);
//        BeanDefinition beanDefinition = new RootBeanDefinition(UserDao.class);
//        beanDefinition.getConstructorArgumentValues()
//                .addGenericArgumentValue(new RuntimeBeanReference("jdbcTemplate"));
//        applicationContext.registerBeanDefinition("userDao", beanDefinition);
//        ClassPathXmlApplicationContext applicationContext =
//                new ClassPathXmlApplicationContext("daoFactory.xml");
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext("kr.ac.jejunu");
        userDao = applicationContext.getBean("userDao", UserDao.class);
    }
    @Test
    public void findById() throws SQLException, ClassNotFoundException {
        Integer id = 1;
        String name = "hulk";
        String password = "1234";
        User user = userDao.findById(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void insert() throws SQLException, ClassNotFoundException {
        String name = "hulk";
        String password = "1111";
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        userDao.insert(user);

        assertThat(user.getId(), greaterThan(0));

        User insertedUser = userDao.findById(user.getId());
        assertThat(insertedUser.getName(), is(user.getName()));
        assertThat(insertedUser.getPassword(), is(user.getPassword()));
    }

    @Test
    public void update() throws SQLException {
        //사용자추가
        User user = new User();
        user.setPassword("1234");
        user.setName("hulk");
        userDao.insert(user);
        //수정
        String updatedName = "허윤호";
        String updatedPassword = "1111";

        user.setName(updatedName);
        user.setPassword(updatedPassword);

        userDao.update(user);
        User updatedUser = userDao.findById(user.getId());

        assertThat(updatedUser.getName(), is(updatedName));
        assertThat(updatedUser.getPassword(), is(updatedPassword));

    }

    @Test
    public void delete() throws SQLException {
        //사용자추가
        User user = new User();
        user.setPassword("1234");
        user.setName("hulk");
        userDao.insert(user);
        //삭제
        userDao.delete(user.getId());

        User deletedUser = userDao.findById(user.getId());
        assertThat(deletedUser, nullValue());
    }
}













