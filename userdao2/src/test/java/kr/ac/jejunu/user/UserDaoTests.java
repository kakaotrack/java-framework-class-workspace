package kr.ac.jejunu.user;

import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

public class UserDaoTests {
    String name = "hulk";
    String password = "1234";

    private static UserDao userDao;

    @BeforeAll
    public static void setup() throws ClassNotFoundException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("kr.ac.jejunu.user");
//        StaticApplicationContext applicationContext = new StaticApplicationContext();
//
//        BeanDefinition dataSourceBeanDefinition = new RootBeanDefinition(SimpleDriverDataSource.class);
//        dataSourceBeanDefinition.getPropertyValues().addPropertyValue("driverClass"
//                , Class.forName(System.getenv("DB_CLASSNAME")));
//        dataSourceBeanDefinition.getPropertyValues().addPropertyValue("url"
//                , System.getenv("DB_URL"));
//        dataSourceBeanDefinition.getPropertyValues().addPropertyValue("username"
//                , System.getenv("DB_USERNAME"));
//        dataSourceBeanDefinition.getPropertyValues().addPropertyValue("password"
//                , System.getenv("DB_PASSWORD"));
//        applicationContext.registerBeanDefinition("dataSource", dataSourceBeanDefinition);
//
//        BeanDefinition jdbcContextBeanDefinition = new RootBeanDefinition(JdbcTemplate.class);
//        jdbcContextBeanDefinition.getConstructorArgumentValues().addGenericArgumentValue(new RuntimeBeanReference("dataSource"));
//        applicationContext.registerBeanDefinition("jdbcContext", jdbcContextBeanDefinition);
//
//        BeanDefinition beanDefinition = new RootBeanDefinition(UserDao.class);
//        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(new RuntimeBeanReference("jdbcContext"));
//        applicationContext.registerBeanDefinition("userDao", beanDefinition);

//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("daoFactory.xml");
//        ApplicationContext applicationContext = new GenericGroovyApplicationContext("daoFactory.groovy");

        userDao = applicationContext.getBean("userDao", UserDao.class);
    }

    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Integer id = 1;

        User user = userDao.get(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void insert() throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        userDao.insert(user);
        assertThat(user.getId(), greaterThan(0));

        User insertedUser = userDao.get(user.getId());
        assertThat(insertedUser.getName(), is(name));
        assertThat(insertedUser.getPassword(), is(password));
    }

    @Test
    public void update() throws SQLException {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        userDao.insert(user);

        String updatedName = "허윤호";
        String updatedPassword = "1111";
        user.setName(updatedName);
        user.setPassword(updatedPassword);

        userDao.update(user);

        User updatedUser = userDao.get(user.getId());
        assertThat(updatedUser.getName(), is(updatedName));
        assertThat(updatedUser.getPassword(), is(updatedPassword));
    }

    @Test
    public void delete() throws SQLException {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        userDao.insert(user);

        userDao.delete(user.getId());

        User deletedUser = userDao.get(user.getId());

        assertThat(deletedUser, IsNull.nullValue());
    }


}
