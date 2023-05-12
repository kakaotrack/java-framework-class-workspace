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
    private static UserDao userDao;
    @BeforeAll
    public static void setup() throws ClassNotFoundException {
//        ApplicationContext applicationContext =
//                new AnnotationConfigApplicationContext(DaoFactory.class);
//        StaticApplicationContext applicationContext = new StaticApplicationContext();
//
//        BeanDefinition dataSourceBeanDefinition = new RootBeanDefinition(SimpleDriverDataSource.class);
//        dataSourceBeanDefinition.getPropertyValues()
//                .add("driverClass", Class.forName(
//                        System.getenv("DB_CLASSNAME")
//                ))
//                .add("url", System.getenv("DB_URL"))
//                .add("username", System.getenv("DB_USERNAME"))
//                .add("password", System.getenv("DB_PASSWORD"))
//
//        ;
//        applicationContext.registerBeanDefinition("dataSource", dataSourceBeanDefinition);
//
//        BeanDefinition jdbcTemplateBeanDefinition = new RootBeanDefinition(JdbcTemplate.class);
//        jdbcTemplateBeanDefinition.getConstructorArgumentValues()
//                .addGenericArgumentValue(new RuntimeBeanReference("dataSource"));
//        applicationContext.registerBeanDefinition("jdbcTemplate", jdbcTemplateBeanDefinition);
//
//        BeanDefinition beanDefinition = new RootBeanDefinition(UserDao.class);
//        beanDefinition.getConstructorArgumentValues()
//                .addGenericArgumentValue(new RuntimeBeanReference("jdbcTemplate"));
//        applicationContext.registerBeanDefinition("userDao", beanDefinition);
//        ApplicationContext applicationContext =
//                new ClassPathXmlApplicationContext("daoFactory.xml");
//        ApplicationContext applicationContext = new
//                GenericGroovyApplicationContext("daoFactory.groovy");
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("kr.ac.jejunu.user");

        userDao = applicationContext.getBean("userDao", UserDao.class);
    }
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Long id = 1l;
        String name = "hulk";
        String password = "1234";
        User user = userDao.findById(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void insert() throws SQLException, ClassNotFoundException {
        String name = "허윤호";
        String password = "1111";
        User user = User.builder().name(name).password(password).build();
//        User user = new User();
//        User user = new User(id, name, password);;
        user.setName(name);
        user.setPassword(password);
        userDao.insert(user);
        assertThat(user.getId(), greaterThan(1l));

        User insertedUser = userDao.findById(user.getId());
        assertThat(insertedUser.getId(),  is(user.getId()));
        assertThat(insertedUser.getName(), is(name));
        assertThat(insertedUser.getPassword(), is(password));
    }

    @Test
    public void update() throws SQLException, ClassNotFoundException {
        User user = insertedUser();
        String updatedName = "updatedHulk";
        String updatedPassword = "2222";
        user.setName(updatedName);
        user.setPassword(updatedPassword);
        userDao.update(user);

        User updatedUser = userDao.findById(user.getId());
        assertThat(updatedUser.getName(), is(updatedName));
        assertThat(updatedUser.getPassword(), is(updatedPassword));

    }

    private User insertedUser() throws ClassNotFoundException, SQLException {
        String name = "허윤호";
        String password = "1111";
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        userDao.insert(user);
        return user;
    }

    @Test
    public void delete() throws SQLException, ClassNotFoundException {
        User user = insertedUser();
        userDao.delete(user.getId());

        User deletedUser = userDao.findById(user.getId());

        assertThat(deletedUser, IsNull.nullValue());

    }

}












