package kr.ac.jejunu.user;

import jakarta.persistence.GeneratedValue;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentDao commentDao;

    @PostMapping
    public Comment add(@RequestBody Comment comment) {
        return commentDao.save(comment);
    }

    @GetMapping("/{id}")
    public Comment get(@PathVariable Long id) {
        return commentDao.findById(id).get();
    }
}
