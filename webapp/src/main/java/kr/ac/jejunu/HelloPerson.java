package kr.ac.jejunu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by hyh0408 on 2017. 5. 12..
 */
@Component("helloPerson")
public class HelloPerson implements Hello{
    @Value("허윤호")
    private String name;
    @Autowired
    private Hello hello;


    @Override
    public String sayHello() {
        return hello.sayHello() + " " + name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHello(Hello hello) {
        this.hello = hello;
    }
}
