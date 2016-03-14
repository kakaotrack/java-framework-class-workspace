package kr.ac.jejunu.service;

import kr.ac.jejunu.dao.UserDao;
import kr.ac.jejunu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hyh0408 on 2016. 3. 11..
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> list() {
        return (List<User>) userDao.findAll();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User get(Long id) {
        User user = new User();
        if(id != null) {
            user = userDao.findOne(id);
        }
        return user;
    }

    @Override
    public void remove(Long id) {
        userDao.delete(id);
    }
}
