package kr.ac.jejunu.spring;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hyh0408 on 2017. 5. 19..
 */

@Controller("/simple*")
public class SimpleController implements org.springframework.web.servlet.mvc.Controller{
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("simple");
//        ModelAndView modelAndView = null;
        modelAndView.addObject("hello", "안녕!!!! ");
        return modelAndView;
    }

    @ExceptionHandler(NullPointerException.class)
    public ModelAndView nullPointException(NullPointerException e) {
        ModelAndView modelAndView = new ModelAndView("error");
        return modelAndView;
    }
}
