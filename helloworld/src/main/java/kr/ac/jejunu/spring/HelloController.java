package kr.ac.jejunu.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hyh0408 on 2016. 5. 12..
 */
@Controller
@RequestMapping("/spring")
public class HelloController {
    @RequestMapping("/hello")
    public void hello(Model model) {
        model.addAttribute("hello world!!");
    }

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET)
    public String hello2(@PathVariable String name, Model model) {
        model.addAttribute("hello world!! " + name);
        return "/spring/hello";
    }

    @RequestMapping("/{hello:[a-z]+}/{name:[a-z]+}")
    public String hello3(@PathVariable String hello, @PathVariable String name, Model model) {
        model.addAttribute(hello + " !! " + name);
        return "/spring/hello";
    }

    @RequestMapping("/hi/{hello}")
    public String hello4(@PathVariable String hello, @MatrixVariable String name,
                         Model model) {
        model.addAttribute(hello + " !! " + name);
        return "/spring/hello";
    }
}
