package kr.ac.jejunu.usermanagement.controller;

import kr.ac.jejunu.usermanagement.dao.UserDao;
import kr.ac.jejunu.usermanagement.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserDao userDao;

    @GetMapping("/list")
    public List<User> list() {
        return userDao.findAll();
    }

    @RequestMapping(value = "save", method = {RequestMethod.POST, RequestMethod.PUT})
    public User add(@RequestBody User user) {
        return userDao.save(user);
    }

    @GetMapping("get/{id}")
    public User get(@PathVariable Long id) {
        return userDao.findById(id).get();
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        userDao.delete(userDao.findById(id).get());
    }
}
