package kr.ac.jejunu.usermanagement.controller;

import kr.ac.jejunu.usermanagement.model.User;
import kr.ac.jejunu.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/api")
public class UserApiController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/list")
    public List<User> list() {
        return userRepository.findAll();
    }

    @PostMapping("/save")
    public User save(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/get/{id}")
    public User get(@PathVariable("id") Integer id) {
        return userRepository.findById(id).get();
    }

    @PutMapping("/save")
    public User modify(@RequestBody @Valid User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        userRepository.delete(userRepository.findById(id).get());
    }
}
