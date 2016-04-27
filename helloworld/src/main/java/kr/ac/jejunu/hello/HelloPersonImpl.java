package kr.ac.jejunu.hello;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hyh0408 on 2016. 4. 27..
 */
public class HelloPersonImpl implements HelloPerson{

    private String name;
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
