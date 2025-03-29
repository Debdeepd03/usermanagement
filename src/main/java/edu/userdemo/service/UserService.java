package edu.userdemo.service;

import edu.userdemo.dto.UserDTO;
import edu.userdemo.entity.User;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO user);//THIS method is used to create a user.
    List<UserDTO> getAllUser();
    //get a particular user
    UserDTO getUserById(Integer id);
    //updating  an user by UserDTO
    UserDTO updateUser(UserDTO userDTO,Integer id);
    String deleteUser(Integer id);
}
