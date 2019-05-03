package kr.ac.jejunu.applicationcontext;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ResouceApplicationContext {
    @Test
    public void xmlApplicationContextTest() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Hello hello = context.getBean("helloPerson", Hello.class);
        assertThat(hello.sayHello(), is("Hello!! hulk"));
    }

    @Test
    public void groovyApplicationContextTest() {
        GenericGroovyApplicationContext context =
                new GenericGroovyApplicationContext("applicationContext.groovy");
        Hello hello = context.getBean("helloPerson", Hello.class);
        assertThat(hello.sayHello(), is("Hello!! hulk"));
    }

    @Test
    public void applicationContextTest() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("kr.ac.jejunu.applicationcontext");
        Hello hello = applicationContext.getBean("helloPerson", Hello.class);
        assertThat(hello.sayHello(), is("Hello!! hulk"));
    }
}
