package kr.ac.jeju.user2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserDao userDao;

    @GetMapping("/user/{id}")
    public User get(@PathVariable Integer id) {
        return userDao.findById(id).orElse(new User());
    }
}
