package kr.ac.jejunu.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/annotation")
public class AnnotationController {
    @RequestMapping
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView("helloworld");
        modelAndView.addObject("hello", "annotation hi");
        return modelAndView;
    }
}
