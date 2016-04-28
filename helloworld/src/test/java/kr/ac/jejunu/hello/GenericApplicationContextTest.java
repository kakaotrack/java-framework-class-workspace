package kr.ac.jejunu.hello;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Created by hyh0408 on 2016. 4. 28..
 */
public class GenericApplicationContextTest {
    @Test
    public void applicatoinContext() {
        GenericApplicationContext applicationContext = new GenericApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        reader.loadBeanDefinitions("applicationContext.xml");
        applicationContext.refresh();
        HelloPerson helloPerson = applicationContext.getBean("helloPerson", HelloPerson.class);
        MatcherAssert.assertThat(helloPerson.sayHello(), CoreMatchers.is("Hello!!! 허윤호"));
    }
}
