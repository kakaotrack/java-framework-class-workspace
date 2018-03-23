package kr.ac.jejunu;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;


public class UserDaoTest {

    private UserDao userDao;
    private DaoFactory daoFactory;
//    private UserDao hallaUserDao;

    @Before
    public void setup() {
        userDao = daoFactory.getUserDao();
    }

    @Test
    public void get() throws SQLException, ClassNotFoundException {
        int id= 1;
        User user = userDao.get(id);
        assertThat(user.getId(), is(1));
        assertThat(user.getName(), is("허윤호"));
        assertThat(user.getPassword(), is("1234"));
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setName("헐크");
        user.setPassword("1111");
        Integer id = userDao.insert(user);

        User insertedUser = userDao.get(id);
        assertThat(insertedUser.getId(), is(id));
        assertThat(insertedUser.getName(), is(user.getName()));
        assertThat(insertedUser.getPassword(), is(user.getPassword()));
    }

//    @Test
//    public void hallaGet() throws SQLException, ClassNotFoundException {
//        int id= 1;
//        User user = hallaUserDao.get(id);
//        assertThat(user.getId(), is(1));
//        assertThat(user.getName(), is("허윤호"));
//        assertThat(user.getPassword(), is("1234"));
//    }
//
//    @Test
//    public void hallaAdd() throws SQLException, ClassNotFoundException {
//        User user = new User();
//        user.setName("헐크");
//        user.setPassword("1111");
//        Integer id = hallaUserDao.insert(user);
//
//        User insertedUser = hallaUserDao.get(id);
//        assertThat(insertedUser.getId(), is(id));
//        assertThat(insertedUser.getName(), is(user.getName()));
//        assertThat(insertedUser.getPassword(), is(user.getPassword()));
//    }
}
