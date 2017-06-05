package kr.ac.jejunu;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanNameReference;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;

/**
 * Created by hyh0408 on 2017. 5. 9..
 */
public class StaticApplicationTest{

    @Test
    public void applicationContext() {
        StaticApplicationContext applicationContext = new StaticApplicationContext();
        applicationContext.registerSingleton("hello", HelloImpl.class);
        Hello hello = applicationContext.getBean("hello", Hello.class);
        System.out.println(hello.sayHello());
    }

    @Test
    public void appicationContextUsingBeanDefinition() {
        StaticApplicationContext applicationContext = new StaticApplicationContext();
        applicationContext.registerSingleton("hello", HelloImpl.class);
        BeanDefinition beanDefinition = new RootBeanDefinition(HelloPerson.class);
        beanDefinition.getPropertyValues().addPropertyValue("name", "허윤호");
        beanDefinition.getPropertyValues().addPropertyValue("hello", new RuntimeBeanReference("hello"));
        applicationContext.registerBeanDefinition("helloPerson", beanDefinition);
        Hello hello = applicationContext.getBean("helloPerson", Hello.class);
        System.out.println(hello.sayHello());
    }
}
