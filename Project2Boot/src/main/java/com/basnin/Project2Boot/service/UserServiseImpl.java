package com.basnin.Project2Boot.service;


import com.basnin.Project2Boot.dao.UserDao;
import com.basnin.Project2Boot.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserServiseImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiseImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User getUser(long id) {
        return userDao.getUser(id);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

}
