package kr.ac.jejunu.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
    @GetMapping(value = "{id}")
    public User get(@PathVariable("id") Integer id) {
        return User.builder().id(id).name("hulk").password("1245").build();
    }

    @PostMapping
    public User add(@RequestBody User user) {
        return user;
    }
}
