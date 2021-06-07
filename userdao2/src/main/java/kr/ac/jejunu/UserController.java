package kr.ac.jejunu;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Map;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserDao userDao;

    @GetMapping(value = "/user/{id}", produces = "application/json")
    public User getUser(@PathVariable Integer id) {
        User u = userDao.findById(id).orElse(null);
        return u;
    }

    @GetMapping(value = "/user/session", produces = "application/json")
    public User sessionUser(HttpSession session) {
        return (User) session.getAttribute("user");
    }

    @GetMapping("/upload")
    public void upload() {
    }

    @PostMapping("/upload")
    public ModelAndView upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        String path = request.getServletContext().getRealPath("/")
                + "/WEB-INF/static/" + file.getOriginalFilename();
        File saveFile = new File(path);
        FileOutputStream fileOutputStream = new FileOutputStream(saveFile);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(file.getBytes());
        bufferedOutputStream.close();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url", "/images/" + file.getOriginalFilename());
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView error(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("e", e);
        return modelAndView;
    }
}
