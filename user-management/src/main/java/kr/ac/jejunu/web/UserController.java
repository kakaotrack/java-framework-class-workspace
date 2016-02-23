package kr.ac.jejunu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @RequestMapping("/")
    String home() {
        return "forward:list";
    }
}
