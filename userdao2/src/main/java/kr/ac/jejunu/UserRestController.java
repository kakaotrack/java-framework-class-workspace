package kr.ac.jejunu;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class UserRestController {

    private final UserDao userDao;

    @GetMapping("/{id}")
    public User get(@PathVariable Integer id) {
        return userDao.findById(id).orElse(null);
    }

    @PostMapping("/user")
    public void save(@RequestBody User user) {
        userDao.save(user);
    }
}
