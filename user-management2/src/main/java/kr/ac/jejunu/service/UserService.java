package kr.ac.jejunu.service;

import kr.ac.jejunu.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void list() {
        userDao.findAll();
    }
}
