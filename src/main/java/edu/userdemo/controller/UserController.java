package edu.userdemo.controller;

import edu.userdemo.dto.UserDTO;
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
    //calling service layer to create a new user given from postman.

    @PostMapping("create")
    public UserDTO createUserController(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }
    @GetMapping("all")
    public List<UserDTO> getAllUserController() {
        return userService.getAllUser();
    }
    @GetMapping("all/{id}")
    public UserDTO getUserController(@PathVariable Integer id) {
        return userService.getUserById(id);
    }
    @PutMapping("update/{id}")
    public UserDTO updateUserController(@RequestBody UserDTO userDTO, @PathVariable Integer id) {
        return userService.updateUser(userDTO,id);
    }
    @DeleteMapping("delete/{id}")
    public String deleteUserController(@PathVariable Integer id) {
      return   userService.deleteUser(id);
    }


}
