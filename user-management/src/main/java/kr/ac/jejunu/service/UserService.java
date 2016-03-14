package kr.ac.jejunu.service;

import kr.ac.jejunu.model.User;

import java.util.List;

/**
 * Created by hyh0408 on 2016. 3. 11..
 */
public interface UserService {
    List<User> list();

    void save(User user);

    User get(Long id);

    void remove(Long id);
}
