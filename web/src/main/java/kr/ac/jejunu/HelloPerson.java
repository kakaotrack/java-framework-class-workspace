package kr.ac.jejunu;

/**
 * Created by hyh0408 on 2017. 5. 9..
 */
public class HelloPerson implements Hello {

    private String name;
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
