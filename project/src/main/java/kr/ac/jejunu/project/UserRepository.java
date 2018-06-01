package kr.ac.jejunu.project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select u from User u join u.comment c where u.name = :name and u.password = :password")
    Page<User> findAllByNameAndPassword(@Param("name") String name, @Param("password") String password, Pageable pageable);
}
