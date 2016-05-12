package kr.ac.jejunu.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hyh0408 on 2016. 5. 12..
 */
@Controller
public class HelloController {
    @RequestMapping("/spring/hello")
    public void hello() {

    }
}
