package kr.ac.jejunu.hello;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
@RequiredArgsConstructor
public class HelloPerson implements Hello{
    @Value("허윤호")
    private String name;
    private final Hello hello;

    @Override
    public String sayHello() {
        return hello.sayHello() + " " + name;
    }
}
