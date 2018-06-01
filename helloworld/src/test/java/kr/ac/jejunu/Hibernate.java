package kr.ac.jejunu;

import kr.ac.jejunu.hello.Comment;
import kr.ac.jejunu.hello.User;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

@Slf4j
public class Hibernate {

    SessionFactory sessionFactory;

    @Before
    public void setup() {
        Configuration configuration = new Configuration().configure("jejunu.cfg.xml")
                .addResource("User.hbm.xml")
                .addResource("Comment.hbm.xml");
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        try {
            sessionFactory = configuration.buildSessionFactory(registry);
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    @After
    public void finish() {
        sessionFactory.close();
    }

    @Test
    public void get() {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, 1);
        assertThat(user.getName(), is("허윤호"));
        assertThat(user.getPassword(), is("1234"));
        user.getComments().forEach(comment -> {
            log.info(comment.getContent());
        });
        session.close();
    }

    @Test
    public void getComment() {
        Session session = sessionFactory.openSession();
        Comment comment = session.get(Comment.class, 1);
        log.info(comment.getUser().getId().toString());
        log.info(comment.getUser().getName());
        log.info(comment.getUser().getPassword());
        session.close();
    }

    @Test
    public void listComment() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Comment");
        List<Comment> comments = query.list();
        comments.forEach(comment -> {
            log.info(comment.getUser().getName());
        });
        session.close();
    }

    @Test
    public void save() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        User user = new User();
        user.setName("testuser");
        user.setPassword("1111");
        session.save(user);

        User savedUser = session.get(User.class, user.getId());
        assertThat(savedUser.getName(), is(user.getName()));
        assertThat(savedUser.getPassword(), is(user.getPassword()));

        session.getTransaction().commit();
        session.close();
    }
}
