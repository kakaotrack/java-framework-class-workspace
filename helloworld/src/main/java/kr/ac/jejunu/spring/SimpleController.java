package kr.ac.jejunu.spring;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
@RequestMapping("/helloworld")
public class SimpleController {

    @RequestMapping("/hi")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("hello", "Hello World!!!");
        return modelAndView;
    }
}
