package kr.ac.jejunu.service;

import kr.ac.jejunu.dao.UserDao;
import kr.ac.jejunu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> list() {
        return (List<User>) userDao.findAll();
    }
}
