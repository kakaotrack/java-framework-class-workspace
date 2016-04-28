package kr.ac.jejunu.hello;

import org.springframework.stereotype.Component;

/**
 * Created by hyh0408 on 2016. 4. 27..
 */
@Component("hello")
public class HelloImpl implements Hello{
    @Override
    public String sayHello() {
        return "Hello!!!";
    }
}
