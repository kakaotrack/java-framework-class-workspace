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
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.OrderingComparison.greaterThan;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindAll() {
        String name = "허윤호";
        User user = User.builder().name(name).build();
        entityManager.persist(user);
        List<User> users = userRepository.findAll();
        assertThat(users.get(0).getId(), is(user.getId()));
        assertThat(users.get(0).getName(), is(user.getName()));
    }

    @Test
    public void testCreate() {
        String name = "허윤호";
        String password = "1234";
        User user = User.builder().name(name).password(password).build();
        user = userRepository.save(user);
        assertThat(user.getId(), greaterThan(0));
        assertThat(user.getName(), is(user.getName()));
        assertThat(user.getPassword(), is(user.getPassword()));
    }

    @Test
    public void testGet() {
        User user = User.builder().name("허윤호").password("1234").build();
        user = userRepository.save(user);
        User getUser = userRepository.findById(user.getId()).get();
        assertThat(getUser.getId(), is(user.getId()));
        assertThat(getUser.getName(), is(user.getName()));
        assertThat(getUser.getPassword(), is(user.getPassword()));
    }

    @Test
    public void testModify() {
        String name = "허윤호";
        String password = "1234";
        User user = userRepository.save(User.builder().name(name).password(password).build());
        User modifyUser = User.builder().id(user.getId()).name("hulk").password("1111").build();
        modifyUser = userRepository.save(modifyUser);
        assertThat(modifyUser.getId(), is(user.getId()));
        assertThat(modifyUser.getName(), is("hulk"));
        assertThat(modifyUser.getPassword(), is("1111"));
    }

    @Test
    public void testDelete() {
        String name = "허윤호";
        String password = "1234";
        User user = userRepository.save(User.builder().name(name).password(password).build());
        userRepository.delete(user);
        user = userRepository.findById(user.getId()).orElse(null);
        assertThat(user, nullValue());
    }



}
