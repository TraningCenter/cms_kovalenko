package com.netcracker.unc.service;

import com.netcracker.unc.dao.UserDao;
import com.netcracker.unc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public List<User> getAll() {
        return userDao.getAllUsers();
    }

    @Transactional
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Transactional
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }
}
