package com.basnin.Project2Boot.service;

import com.basnin.Project2Boot.model.User;
import java.util.List;


public interface UserService {
    void addUser(User user);
    void deleteUser(long id);
    void updateUser(User user);
    User getUser(long id);

    List<User> getUsers();


}
