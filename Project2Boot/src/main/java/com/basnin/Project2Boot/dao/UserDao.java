package com.basnin.Project2Boot.dao;

import com.basnin.Project2Boot.model.User;
import java.util.List;


public interface UserDao {
    void addUser(User user);
    void deleteUser(long id);
    void updateUser(User user);
    User getUser(long id);

    List<User> getUsers();


}
