package edu.userdemo.controller;

import edu.userdemo.entity.User;
import edu.userdemo.repository.UserRepository;
import edu.userdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("crud")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUserController(@RequestBody User user) {
        return userService.createUser(user);
    }
    @GetMapping("all")
    public List<User> getAllUserController() {
        return userService.getAllUser();
    }
    @GetMapping("all/{id}")
    public User getUserController(@PathVariable Integer id) {
        return userService.getUserById(id);
    }
    @PutMapping("update/{id}")
    public User updateUserController(@RequestBody User user, @PathVariable Integer id) {
        return userService.updateUser(user,id);
    }
    @DeleteMapping("delete/{id}")
    public String deleteUserController(@PathVariable Integer id) {
      return   userService.deleteUser(id);
    }


}
