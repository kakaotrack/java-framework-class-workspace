package kr.ac.jejunu.spring;

import kr.ac.jejunu.hello.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
