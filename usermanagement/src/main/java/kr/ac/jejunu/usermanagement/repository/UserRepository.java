package kr.ac.jejunu.usermanagement.repository;

import kr.ac.jejunu.usermanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
