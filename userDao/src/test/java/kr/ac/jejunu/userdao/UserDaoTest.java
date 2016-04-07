package kr.ac.jejunu.userdao;

import static org.hamcrest.MatcherAssert.*;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;

/**
 * Created by hyh0408 on 2016. 3. 22..
 */
public class UserDaoTest {

    UserDao userDao;

    @Before
    public void setup() {
        ApplicationContext context = new GenericXmlApplicationContext("daoFactory.xml");
//        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        userDao = context.getBean("userDao", UserDao.class);
    }


    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Long id = 1L;
        String name = "허윤호";
        String password = "1234";

        User user = userDao.get(id);
        validate(id, name, password, user);
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        String name = "헐크";
        String password = "1234";

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        Long id = userDao.add(user);


        User resultUser = userDao.get(id);
        validate(id, name, password, resultUser);

    }

    private void validate(Long id, String name, String password, User user) {
        assertThat(id, is(user.getId()));
        assertThat(name, is(user.getName()));
        assertThat(password, is(user.getPassword()));
    }
}


