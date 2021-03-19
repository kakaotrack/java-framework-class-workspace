package kr.ac.jejunu;

import org.junit.jupiter.api.Test;

public class UserDaoTests {
    @Test
    public void get() {
        Integer id = 1;
        String name = "hulk";
        String password = "1234";

        UserDao userDao = new UserDao();
        User user = userDao.findById(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }
}
