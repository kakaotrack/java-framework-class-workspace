package kr.ac.jejunu.applicationcontext;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StaticApplicationContextTests {
    @Test
    public void HelloImplTest() {
        StaticApplicationContext context = new StaticApplicationContext();
        context.registerSingleton("hello", HelloImpl.class);
        Hello hello = context.getBean("hello", Hello.class);
        assertThat(hello.sayHello(), is("Hello!!"));
    }

    @Test
    public void HelloPersonTest() {
        StaticApplicationContext context = new StaticApplicationContext();
        context.registerSingleton("hello", HelloImpl.class);
        BeanDefinition beanDefinition = new RootBeanDefinition(HelloPerson.class);
        beanDefinition.getPropertyValues()
                .addPropertyValue("name", "hulk");
        beanDefinition.getConstructorArgumentValues()
                .addGenericArgumentValue(new RuntimeBeanReference("hello"));
        context.registerBeanDefinition("helloPerson", beanDefinition);
        Hello hello = context.getBean("helloPerson", Hello.class);
        assertThat(hello.sayHello(), is("Hello!! hulk"));
    }
}



















