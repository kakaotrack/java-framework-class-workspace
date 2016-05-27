package kr.ac.jejunu.repository;

import kr.ac.jejunu.model.Comment;
import kr.ac.jejunu.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hyh0408 on 2016. 5. 26..
 */
public interface CommentRepository extends PagingAndSortingRepository<Comment, Integer> {
}
