package kr.ac.jejunu.applicationcontext;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component("helloPerson")
public class HelloPerson implements Hello{
    @Value("hulk")
    private String name;
    private Hello hello;

    @Autowired
    public HelloPerson(Hello hello) {
        this.hello = hello;
    }
    @Override
    public String sayHello() {
        return hello.sayHello() + " " + name;
    }
}
