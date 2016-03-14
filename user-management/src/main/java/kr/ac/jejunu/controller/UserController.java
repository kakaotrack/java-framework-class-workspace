package kr.ac.jejunu.controller;

import kr.ac.jejunu.model.User;
import kr.ac.jejunu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by hyh0408 on 2016. 3. 11..
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("list")
    public List<User> list() {
        List<User>  userList = userService.list();
        return userList;
    }

    @RequestMapping("save")
    public String save(User user) {
        userService.save(user);
        return "redirect:/list";
    }

    @RequestMapping({"create", "edit"})
    public String edit(Long id, ModelMap model) {
        User user = userService.get(id);
        model.addAttribute(user);
        return "edit";
    }

    @RequestMapping("remove")
    public String remove(Long id){
        userService.remove(id);
        return "redirect:/list" ;
    }
}
