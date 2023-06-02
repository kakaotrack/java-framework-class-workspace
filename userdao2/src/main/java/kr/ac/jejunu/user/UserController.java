package kr.ac.jejunu.user;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserDao userDao;

    @RequestMapping(path = "/user/{id}", produces = "text/html")
    public ModelAndView getUser(@PathVariable Long id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user == null)
            user = userDao.findById(id);
        session.setAttribute("user", User.builder().name("SESSION").build());
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping(path = "user", produces = "application/json")
    public @ResponseBody User modelAttribute() {
        User user = new User();
        user.setName("HULK");
        return user;
    }

    @GetMapping("redirect")
    public View redirect(User user) {
        user.setName("HULK");
        return new MappingJackson2JsonView();
    }

    @PostMapping("body")
    public @ResponseBody User requestBody(@RequestBody User user) {
        return userDao.findById(user.getId());
    }



    @GetMapping("cookie")
    public ModelAndView cookie(@CookieValue(value = "name", required = false) String name, HttpServletResponse response) {
        User user = User.builder().name("NO COOKIE").build();
        if(name != null)
            user = User.builder().name(name).build();
        response.addCookie(new Cookie("name", "COOKIE"));
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user", user);
        return modelAndView;
    }


    @RequestMapping("/exception")
    public void exception() {
        throw new RuntimeException("어이쿠 !!!!");
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView error(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("e", e);
        return modelAndView;
    }

    @GetMapping("upload")
    public void upload() {
    }

    @PostMapping("upload")
    public ModelAndView upload(@RequestParam("file") MultipartFile file
            , HttpServletRequest request) throws IOException {
        String path = request.getServletContext().getRealPath("/") +
                "/WEB-INF/static/" + file.getOriginalFilename();
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        BufferedOutputStream bufferedOutputStream =
                new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(file.getBytes());
        bufferedOutputStream.close();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url", "/images/"
                + file.getOriginalFilename());
        return modelAndView;
    }
}
