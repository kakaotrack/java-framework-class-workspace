package kr.ac.jejunu.spring;

import kr.ac.jejunu.hello.Comment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
@Slf4j
public class SpringDataJpaController {

    private final CommentRepository commentRepository;

    @GetMapping
    public List<Comment> list() {
        return (List<Comment>) commentRepository.findAll();
    }
}
