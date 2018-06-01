package kr.ac.jejunu.project;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/{id}")
    public User get(@PathVariable Integer id) {
        return userRepository.findById(id).get();
    }

    @GetMapping("/list")
    public List<User> list() {
        return userRepository.findAll();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping
    public void modify(@RequestBody User user) {
        userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userRepository.delete(userRepository.findById(id).get());
    }

    @GetMapping("/findExample")
    public Page<User> findExample(@RequestParam String name, @RequestParam String password
            , @RequestParam Integer page, @RequestParam Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "id");
        return userRepository.findAllByNameAndPassword(name, password, pageRequest);
    }
}
