package kr.ac.jejunu.usermanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {
    private final UserRepository userRepository;

    @Autowired
    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User get(@PathVariable("id") Integer id) {
        return userRepository.findById(id).get();
    }

    @RequestMapping(value = "/user", method = {RequestMethod.POST, RequestMethod.PUT})
    public User save(User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/user/{id}")
    public void remove(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
    }
}
