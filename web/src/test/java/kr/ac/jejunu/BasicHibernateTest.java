package kr.ac.jejunu;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import kr.ac.jejunu.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasicHibernateTest {

    SessionFactory sessionFactory;

    @Before
    public void setup() {
        Configuration configuration = new Configuration().configure("jejunu.cfg.xml");
        configuration.addResource("User.hbm.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(configuration.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        sessionFactory = configuration.buildSessionFactory(standardServiceRegistry);
    }

    @After
    public void finish() {
        sessionFactory.close();
    }

    @Test
    public void getUserTest() {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, 1);
        assertThat(user.getName(), is("허윤호"));
        assertThat(user.getPassword(), is("1234"));
        session.close();
    }

}
