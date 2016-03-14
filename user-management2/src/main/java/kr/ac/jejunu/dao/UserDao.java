package kr.ac.jejunu.dao;

import kr.ac.jejunu.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDao extends CrudRepository<User, Long>{
}
