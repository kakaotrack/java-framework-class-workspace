package kr.ac.jejunu.userdao;

import kr.ac.halla.userdao.HallaUserDao;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * Created by hyh0408 on 2016. 3. 22..
 */
public class UserDaoTest {


    @Test
    public void get() throws SQLException, ClassNotFoundException {
        UserDao userDao = new JejuUserDao();
        Long id = 1L;
        String name = "허윤호";
        String password = "1234";

        User user = userDao.get(id);
        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
        assertEquals(password, user.getPassword());
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        UserDao userDao = new JejuUserDao();

        String name = "헐크";
        String password = "1234";

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        Long id = userDao.add(user);


        User resultUser = userDao.get(id);
        assertEquals(id, resultUser.getId());
        assertEquals(name, resultUser.getName());
        assertEquals(password, resultUser.getPassword());

    }

    @Test
    public void hallaGet() throws SQLException, ClassNotFoundException {
        UserDao userDao = new HallaUserDao();
        Long id = 1L;
        String name = "허윤호";
        String password = "1234";

        User user = userDao.get(id);
        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
        assertEquals(password, user.getPassword());
    }

    @Test
    public void hallaAdd() throws SQLException, ClassNotFoundException {
        UserDao userDao = new HallaUserDao();

        String name = "헐크";
        String password = "1234";

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        Long id = userDao.add(user);


        User resultUser = userDao.get(id);
        assertEquals(id, resultUser.getId());
        assertEquals(name, resultUser.getName());
        assertEquals(password, resultUser.getPassword());

    }
}


