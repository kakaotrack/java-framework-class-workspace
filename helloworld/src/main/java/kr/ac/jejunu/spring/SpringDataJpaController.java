package kr.ac.jejunu.spring;

import kr.ac.jejunu.model.Comment;
import kr.ac.jejunu.model.User;
import kr.ac.jejunu.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by hyh0408 on 2016. 5. 26..
 */
@Controller
@RequestMapping("/data")
public class SpringDataJpaController {

    @Autowired
    CommentRepository commentRepository;

    @RequestMapping("/list")
    public List<Comment> list() {
        return (List<Comment>) commentRepository.findAll();
    }
}
