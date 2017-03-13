package kr.ac.jejunu.dao;

import kr.ac.jejunu.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by hyh0408 on 2017. 3. 10..
 */
public interface UserDao extends CrudRepository<User, Long> {
}
