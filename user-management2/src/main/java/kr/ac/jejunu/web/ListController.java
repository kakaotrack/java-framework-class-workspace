package kr.ac.jejunu.web;

import kr.ac.jejunu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListController {
    @Autowired
    private UserService userService;

    @RequestMapping({"/", "list"})
    public String list(ModelMap modelMap) {
        modelMap.addAttribute(userService.list());
        return "list";
    }
}
