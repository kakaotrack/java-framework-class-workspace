package kr.ac.jejunu;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;

@Controller
public class UserController {
    @GetMapping(path = "/user/{id}/{name}", produces = "application/json")
    public ModelAndView user(
            @PathVariable("id") Integer id
            , @PathVariable("name") String name
    ) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject(user);
        return modelAndView;
    }

    @GetMapping("/upload")
    public void upload() {

    }

    @RequestMapping("/date")
    public ModelAndView date(
            @RequestParam(required = false, defaultValue = "2022-03-03")
            @DateTimeFormat(pattern = "yyyy-MM-dd")
                    Date date) {
        ModelAndView modelAndView = new ModelAndView("date");
        modelAndView.addObject("date", date);
        return modelAndView;
    }

    @PostMapping("/upload")
    public ModelAndView upload(@RequestParam MultipartFile file, HttpServletRequest request) throws IOException {
        File path = new File(request.getServletContext()
                .getRealPath("/") + "/WEB-INF/static/" + file.getOriginalFilename());
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(file.getBytes());
        bufferedOutputStream.close();
        ModelAndView modelAndView = new ModelAndView("upload");
        modelAndView.addObject("url"
                , "/images/" + file.getOriginalFilename());
        return modelAndView;
    }

    @GetMapping(path = "cookie", produces = "application/json")
    public Cookie[] cookie(@CookieValue("hulk") String hulk, HttpServletRequest request, HttpServletResponse response) {

        Cookie cookie = new Cookie("hulk", "1234");
        response.addCookie(cookie);
        return request.getCookies();
    }

    @GetMapping(path = "session", produces = "application/json")
    public User session(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        if(user == null)
            httpSession.setAttribute("user"
                    , User.builder().name("session").password("1111").build());
        return user;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView error(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("e", e);
        return modelAndView;
    }
}
