package kr.ac.jejunu.usermanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/create")
    public String create() {
       return "/edit";
    }

    @PostMapping("/save")
    public String save(User user) {
        userRepository.save(user);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public List<User> list() {
       return userRepository.findAll();
    }

    @GetMapping("/edit")
    public User get(@RequestParam("id") Integer id) {
        return userRepository.findById(id).get();
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("id") Integer id) {
        userRepository.deleteById(id);
        return "redirect:/list";
    }
}
