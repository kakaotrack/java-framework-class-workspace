package kr.ac.jejunu.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hyh0408 on 2017. 5. 19..
 */
@Controller
public class ReqeustController {
    @RequestMapping("/request")
    public String aaa() {
        return "request";
    }
}
