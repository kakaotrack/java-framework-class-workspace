package kr.ac.jejunu.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller("abc")
public class SimpleController implements org.springframework.web.servlet.mvc.Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("simple");
        modelAndView.addObject("abc", "안녕 세상아");
        return modelAndView;
    }
}


