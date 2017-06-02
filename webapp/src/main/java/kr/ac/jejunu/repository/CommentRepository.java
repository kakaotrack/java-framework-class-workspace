package kr.ac.jejunu.repository;

import kr.ac.jejunu.model.Comment;
import kr.ac.jejunu.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
