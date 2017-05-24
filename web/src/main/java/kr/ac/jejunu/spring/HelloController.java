package kr.ac.jejunu.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hyh0408 on 2017. 5. 19..
 */
@Controller
@RequestMapping("/spring")
public class HelloController {
    @RequestMapping("/hi")
    public void hello(Model model) {
        model.addAttribute("hi", "하이!!!");
    }

//    @RequestMapping(value = "/hi/{name}", method = RequestMethod.GET)
    @GetMapping("/hi/{name}")
    public String hello2(@PathVariable String name, Model model)  {
        model.addAttribute("hi", "하이!!! " + name);
        return "hi";
    }


    @GetMapping("/{hi:[a-z]+}/{name:[a-z]+}")
    public String hello3(@PathVariable String hi, @PathVariable String name,  Model model) {
        model.addAttribute("hi", hi + " " + name);
        return "hi";
    }

    @GetMapping("/{hi}")
    public String hello4(@PathVariable String hi, @MatrixVariable("name") String name,  Model model) {
        model.addAttribute("hi", hi + " " + name);
        return "hi";
    }

    @ExceptionHandler(NullPointerException.class)
    public String handleException(NullPointerException e) {
        return "error";
    }
}
