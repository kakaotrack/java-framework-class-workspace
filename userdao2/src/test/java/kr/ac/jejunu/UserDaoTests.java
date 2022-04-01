package kr.ac.jejunu;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserDaoTests {
    private static UserDao userDao;

    @BeforeAll
    public static void setup() {
        ApplicationContext applicationContext
        = new AnnotationConfigApplicationContext(DaoFactory.class);
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













