package kr.ac.jejunu.usermanagement;

import kr.ac.jejunu.usermanagement.model.User;
import kr.ac.jejunu.usermanagement.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.module.ModuleFinder;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;
    Integer id = 1;
    String name = "허윤호";
    String password = "1234";

    @Test
    public void testFindAll() {
        User user = User.builder().name(name).build();
        entityManager.persist(user);
        List<User> users = userRepository.findAll();
        assertThat(users.get(0).getId(), is(user.getId()));
        assertThat(users.get(0).getName(), is(user.getName()));
    }

    @Test
    public void testSave() {
        User user = User.builder().name(name).password(password).build();
        user = userRepository.save(user);
        assertThat(user.getId(), greaterThan(0));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }
}
