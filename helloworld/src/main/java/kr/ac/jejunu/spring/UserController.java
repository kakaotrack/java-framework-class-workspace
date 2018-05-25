package kr.ac.jejunu.spring;

import kr.ac.jejunu.hello.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RequestMapping("/user")
@Controller
@Slf4j
public class UserController {
    @GetMapping("/servlet")
    public void servlet(HttpServletRequest request, HttpServletResponse response,
                        HttpSession session) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        session.setAttribute("user", user);
        response.getWriter().println(String.format
                ("<h1> %s : %s </h1><br />", "ID", id));
        response.getWriter().println(String.format
                ("<h1> %s : %s </h1><br />", "Name", name));
        response.getWriter().println(String.format
                ("<h1> %s : %s </h1><br />", "Password", password));
    }

    @GetMapping("/session")
    public ModelAndView session(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user",
                session.getAttribute("user"));
        return modelAndView;
    }

    @GetMapping("/path/{id}/{name:[a-z]+}")
    public ModelAndView user(@PathVariable Integer id, @PathVariable("name") String name,
                       @RequestParam("password") String password, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("user");
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        modelAndView.addObject("user", user);
        Cookie idCookie = new Cookie("id", String.valueOf(id));
        Cookie nameCookie = new Cookie("name", name);
        Cookie passwordCookie = new Cookie("password", password);
        idCookie.setPath("/user/cookie");
        nameCookie.setPath("/user/cookie");
        passwordCookie.setPath("/user/cookie");
        response.addCookie(idCookie);
        response.addCookie(nameCookie);
        response.addCookie(passwordCookie);
        return modelAndView;
    }
    @GetMapping("/cookie")
    public ModelAndView cookie(@CookieValue("id") Integer id, @CookieValue("name") String name,
                             @CookieValue("password") String password) {
        ModelAndView modelAndView = new ModelAndView("user");
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping
    public User user() {
        return new User();
    }

    @PostMapping
    public void user(User user) {
        log.info("******** void test user ********");
    }

    @GetMapping("/string")
    public String returnStringTest() {
        return "user";
    }

    @GetMapping("/redirect")
    public String redirectStringTest() {
        return "redirect:/user";
    }

    @GetMapping("/forward")
    public String forwardStringTest() {
        return "forward:/user";
    }


}
















