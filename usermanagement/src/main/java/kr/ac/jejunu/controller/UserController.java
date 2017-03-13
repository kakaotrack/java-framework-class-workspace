package kr.ac.jejunu.controller;

import kr.ac.jejunu.model.User;
import kr.ac.jejunu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by hyh0408 on 2017. 3. 10..
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping({"/", "list"})
    public String list(ModelMap modelMap) {
        List<User> users = userService.list();
        modelMap.addAttribute("userList", users);
        return "list";
    }

    @RequestMapping("remove")
    public String remove(Long id) {
        userService.remove(id);
        return "redirect:list";
    }


    @RequestMapping("create")
    public String create() {
        return "create";
    }

    @RequestMapping("register")
    public String register(User user) {
        userService.create(user);
        return "redirect:list";
    }

    @RequestMapping("edit")
    public String edit(Long id, ModelMap modelMap) {
        User user = userService.get(id);
        modelMap.addAttribute("user", user);
        return "edit";
    }

    @RequestMapping("save")
    public String save(User user) {
        userService.save(user);
        return "redirect:list";
    }
}
