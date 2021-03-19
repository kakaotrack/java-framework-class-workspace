package kr.ac.jejunu.usermanagement;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/list")
    public List<User> list() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/save", method = {RequestMethod.POST, RequestMethod.PUT})
    public User save(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Integer id) {
        return userRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userRepository.delete(userRepository.findById(id).get());
    }
}
