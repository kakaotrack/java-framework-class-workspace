package kr.ac.jejunu.hello;

import org.springframework.stereotype.Component;

@Component
public class HelloImpl implements Hello {
    @Override
    public String sayHello() {
        return "Hello!!!";
    }
}
