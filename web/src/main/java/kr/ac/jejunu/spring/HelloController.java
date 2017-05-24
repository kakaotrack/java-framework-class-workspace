package kr.ac.jejunu.spring;

import kr.ac.jejunu.HelloModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by hyh0408 on 2017. 5. 19..
 */
@Controller
@RequestMapping("/spring")
@SessionAttributes("helloModel")
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

    @GetMapping("/hihi")
    public String hello5(@RequestParam String hi, @RequestParam String name, Model model) {
        model.addAttribute("hi", hi + " " + name);
        return "hi";
    }

    @GetMapping("/hellomodel")
    public String hello6(@ModelAttribute HelloModel helloModel, Model model) {
        model.addAttribute("hi", helloModel.getHello() + " " + helloModel.getName());
        return "hi";
    }


    @GetMapping("/hellomodel2")
    public String hello7(HelloModel helloModel) {
        return "hi";
    }

    @GetMapping("/hellomodel3")
    @ModelAttribute
    public HelloModel hello7() {
        HelloModel helloModel = new HelloModel();
        helloModel.setHello("HI");
        helloModel.setName("Hulk");
        return helloModel;
    }

    @GetMapping("/hellomodel4")
    public String hello8(HelloModel model, @CookieValue(value = "name", defaultValue = "hulk")String name, HttpServletResponse res) {
        model.setName(name);
        if("hulk".equals(name))
            res.addCookie(new Cookie("name", "henry"));
        else
            res.addCookie(new Cookie("name", "hulk"));
        return "hi";
    }

    @GetMapping("/hellomodel5")
    public String hello8(HelloModel model, HttpSession session) {
        String name = (String) session.getAttribute("name");
        model.setName(name);
        if("hulk".equals(name))
            session.setAttribute("name", "henry");
        else
            session.setAttribute("name", "hulk");
        return "hi";
    }

    @GetMapping("/sessionattributes/add")
    public String hello9(HelloModel helloModel) {
        helloModel.setHello("안녕");
        helloModel.setName("헐크");
        return "hi";
    }

    @GetMapping("/sessionattributes/get")
    public String hello10() {
        return "hi";
    }

    @ExceptionHandler(NullPointerException.class)
    public String handleException(NullPointerException e) {
        return "error";
    }
}
