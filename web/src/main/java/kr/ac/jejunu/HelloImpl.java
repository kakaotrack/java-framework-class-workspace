package kr.ac.jejunu;

import org.springframework.stereotype.Component;

/**
 * Created by hyh0408 on 2017. 5. 9..
 */
@Component
public class HelloImpl implements Hello{
    @Override
    public String sayHello() {
        return "Hello!!!";
    }
}
