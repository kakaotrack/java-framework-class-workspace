package kr.ac.jejunu.spring;

import kr.ac.jejunu.hello.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
