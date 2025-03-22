package edu.userdemo.service.impl;

import edu.userdemo.entity.User;
import edu.userdemo.repository.UserRepository;
import edu.userdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User updateUser(User user,Integer id) {
        User user1 = userRepository.findById(id).get();
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        return userRepository.save(user1);
    }

    @Override
    public String deleteUser(Integer id) {
        userRepository.deleteById(id);
        return "Deleted User with id " + id;
    }
}
