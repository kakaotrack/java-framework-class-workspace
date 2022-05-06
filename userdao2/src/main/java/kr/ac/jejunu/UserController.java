package kr.ac.jejunu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user2")
public class UserController {
    @RequestMapping
    public ModelAndView user(
            @RequestParam("id") Integer id
            , @RequestParam("name") String name
    ) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject(user);
        return modelAndView;
    }
}
