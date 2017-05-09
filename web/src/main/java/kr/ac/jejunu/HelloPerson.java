package kr.ac.jejunu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by hyh0408 on 2017. 5. 9..
 */
@Component("hello")
public class HelloPerson implements Hello {

    @Value("허윤호")
    private String name;
    @Autowired
    private Hello hello;

    @Override
    public String sayHello() {
        return hello.sayHello() + " " + name;
    }
}
