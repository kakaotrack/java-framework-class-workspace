package kr.ac.jejunu.usermanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

@DataJpaTest
public class UserRepositoryTests {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    String name = "허윤호";
    String password = "1234";

    @Test
    public void findAll() {
        User user = User.builder().name(name).build();
        entityManager.persist(user);
        List<User> users = userRepository.findAll();
        assertThat(users.get(0).getId(), greaterThan(0));
        assertThat(users.get(0).getName(), is(name));
    }

    @Test
    public void save() {
        User user = User.builder().name(name) .password(password).build();
        user = userRepository.save(user);
        assertThat(user.getId(), greaterThan(0));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void update() {
        User user = User.builder().name(name) .password(password).build();
        user = userRepository.save(user);
        String testName = "hulk";
        user.setName(testName);
        User savedUser = userRepository.save(user);
        assertThat(savedUser.getId(), is(user.getId()));
        assertThat(savedUser.getName(), is(testName));
    }
}













