package kr.ac.jejunu.service;

import kr.ac.jejunu.model.User;

import java.util.List;

/**
 * Created by hyh0408 on 2017. 3. 10..
 */
public interface UserService {
    List<User> list();

    void create(User user);

    User get(Long id);

    void save(User user);

    void remove(Long id);
}
