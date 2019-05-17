package kr.ac.jejunu.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/get")
    public ModelAndView get(@RequestParam("id") Integer id, @RequestParam("name") String name, HttpServletResponse response) {
        User user = User.builder().id(id).name(name).password("1234").build();
        response.addCookie(new Cookie("id", id.toString()));
        response.addCookie(new Cookie("name", name));
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping("/user")
    public String model(User user){
        return "user";
    }

    @RequestMapping("/redirect")
    public String redirect() {
        return "redirect:/user/upload";
    }

    @RequestMapping("/forward")
    public String forward() {
        return "forward:/user/upload";
    }


    @RequestMapping("/cookie")
    public ModelAndView cookie(@CookieValue(value = "id", required = false) Integer id, @CookieValue(value = "name", required = false) String name) {
        User user = User.builder().id(id).name(name).password("1234").build();
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping("/get/id/{id}/name/{name}")
    public ModelAndView path(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        User user = User.builder().id(id).name(name).build();
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping("/upload")
    public String uploadpage() {
        return "upload";
    }

    @PostMapping("/upload")
    public ModelAndView upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        File path =
                new File(request.getServletContext().getRealPath("/")
                        + "/WEB-INF/static/" +
                        file.getOriginalFilename());
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(file.getBytes());
        bufferedOutputStream.close();
        ModelAndView modelAndView = new ModelAndView("upload");
        modelAndView.addObject("url", "/images/" + file.getOriginalFilename());
        return modelAndView;
    }

    @RequestMapping("/error")
    public void error() {
        throw new RuntimeException("runtime exception");
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView errorpage(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("e", e);
        return modelAndView;
    }
}
