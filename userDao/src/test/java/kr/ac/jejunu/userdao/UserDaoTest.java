package kr.ac.jejunu.userdao;

import kr.ac.halla.userDao.HallaConnectionMaker;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * Created by hyh0408 on 2016. 3. 22..
 */
public class UserDaoTest {

    UserDao userDao;

    @Before
    public void setup() {
        userDao = new DaoFactory().getUserDao();
    }


    @Test
    public void get() throws SQLException, ClassNotFoundException {
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


