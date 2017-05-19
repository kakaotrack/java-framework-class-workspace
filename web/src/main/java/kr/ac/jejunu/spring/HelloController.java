package kr.ac.jejunu.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hyh0408 on 2017. 5. 19..
 */
@Controller
public class HelloController {
    @RequestMapping("/hi")
    public void hello() {
        String a = null;
        a.toString();
    }

    @ExceptionHandler(NullPointerException.class)
    public String handleException(NullPointerException e) {
        return "error";
    }
}
