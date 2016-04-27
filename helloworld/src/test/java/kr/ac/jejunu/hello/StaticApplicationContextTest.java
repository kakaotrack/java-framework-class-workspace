package kr.ac.jejunu.hello;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanNameReference;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by hyh0408 on 2016. 4. 27..
 */
public class StaticApplicationContextTest {
    @Test
    public void applicationContext() {
        StaticApplicationContext applicationContext = new StaticApplicationContext();
        applicationContext.registerSingleton("hello", HelloImpl.class);
        Hello hello = applicationContext.getBean("hello", Hello.class);
        assertThat(hello.sayHello(), is("Hello!!!"));
    }

    @Test
    public void applicatoinContextUsingBeanDefinition() {
        StaticApplicationContext applicationContext = new StaticApplicationContext();
        applicationContext.registerSingleton("hello", HelloImpl.class);
        BeanDefinition beanDefinition = new RootBeanDefinition(HelloPersonImpl.class);
        beanDefinition.getPropertyValues().addPropertyValue("name", "허윤호");
        beanDefinition.getPropertyValues().addPropertyValue("hello", new RuntimeBeanReference("hello"));
        applicationContext.registerBeanDefinition("helloPerson", beanDefinition);
        HelloPerson helloPerson = applicationContext.getBean("helloPerson", HelloPerson.class);
        assertThat(helloPerson.sayHello(), is("Hello!!! 허윤호"));
    }
}
