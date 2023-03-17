package kr.ac.jejunu.usermanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping("list")
    public List<User> list() {
        return userDao.findAll();
    }

    @RequestMapping(path = "save", method = {RequestMethod.POST, RequestMethod.PUT})
    public User create(@RequestBody User user) {
        return userDao.save(user);
    }

    @GetMapping("get/{id}")
    public User get(@PathVariable Long id) {
        return userDao.findById(id).get();
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        userDao.deleteById(id);
    }
}
