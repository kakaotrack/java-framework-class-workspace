package kr.ac.jejunu.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserRestController {
    private final UserDao userDao;
    @GetMapping("/user/{id}")
    public User get(@PathVariable Long id) {
        return userDao.findById(id);
    }
}
