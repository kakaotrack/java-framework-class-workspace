package kr.ac.jejunu.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by hyh0408 on 2016. 4. 27..
 */
@Component
public class HelloPersonImpl implements HelloPerson{

    @Value("허윤호")
    private String name;
    @Autowired
    private Hello hello;


    @Override
    public String sayHello() {
        return hello.sayHello() + " " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHello(Hello hello) {
        this.hello = hello;
    }
}
