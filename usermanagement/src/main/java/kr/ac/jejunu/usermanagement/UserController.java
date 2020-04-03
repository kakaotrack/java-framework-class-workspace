package kr.ac.jejunu.usermanagement;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/list")
    public List<User> list() {
        return userRepository.findAll();
    }

    @RequestMapping(path = "/save", method = {RequestMethod.POST, RequestMethod.PUT})
    public User save(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/get/{id}")
    public User get(@PathVariable("id") Integer id) {
        return userRepository.findById(id).get();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        userRepository.delete(userRepository.findById(id).get());
    }
}
