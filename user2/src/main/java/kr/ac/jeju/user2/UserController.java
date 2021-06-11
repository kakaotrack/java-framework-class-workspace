package kr.ac.jeju.user2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserDao userDao;

    @PostMapping
    public void save(@RequestBody User user) {
        user.getComments().forEach(comment -> {
            comment.setUser(user);
        });
        userDao.save(user);
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Integer id) {
        User user = userDao.findById(id).orElse(new User());
        System.out.println(user);
        return user;
    }
}
