package edu.userdemo.service;

import edu.userdemo.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAllUser();
    User getUserById(Integer id);
    User updateUser(User user,Integer id);
    String deleteUser(Integer id);
}
