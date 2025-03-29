package edu.userdemo.service.impl;

import edu.userdemo.dto.UserDTO;
import edu.userdemo.entity.User;
import edu.userdemo.exception.ResourceNotFoundException;
import edu.userdemo.repository.UserRepository;
import edu.userdemo.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
@Service
public class UserServiceImpl  implements UserService {
   // @Autowired
    private UserRepository userRepository;
    private ModelMapper modelMapper;
//    @Override
//    public UserDTO createUser(UserDTO userDTO) {
//        User original=new User(
//                userDTO.getId(),
//                userDTO.getName(),
//                userDTO.getEmail()
//        );
//        User saveduser=userRepository.save(original);
//        UserDTO ud=new UserDTO(
//        saveduser.getId(),
//        saveduser.getName(),
//        saveduser.getEmail());
//        return ud;
//        //return userRepository.save(user);
//    }
//@Override
//public UserDTO createUser(UserDTO userDTO) {
//        return UserMapper.userToUserDTO(userRepository.save(UserMapper.userDTOToUser(userDTO)));
//    //return userRepository.save(user);
//}
@Override
public UserDTO createUser(UserDTO userDTO) {
    User user=modelMapper.map(userDTO, User.class);
    User saved=userRepository.save(user);
    return modelMapper.map(saved, UserDTO.class);


}

//    @Override
//    public List<UserDTO> getAllUser() {
//        List<User> users = userRepository.findAll();
//        List<UserDTO> udt = users.stream().map(u -> new UserDTO(u.getId(), u.getName(), u.getEmail())).collect(Collectors.toList());
//        return udt;
//    }
@Override
public List<UserDTO> getAllUser() {
    List<User> users = userRepository.findAll();
    List<UserDTO> udt = users.stream().map(u ->modelMapper.map(u,UserDTO.class)).collect(Collectors.toList());
    return udt;
}

//    @Override
//    public UserDTO getUserById(Integer id) {
//        return UserMapper.userToUserDTO(userRepository.findById(id).get());
//    }
@Override
public UserDTO getUserById(Integer id) {
   // return modelMapper.map(userRepository.findById(id).get(), UserDTO.class);
    User user=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","id",id));
    return modelMapper.map(user,UserDTO.class);
}


    @Override
    public UserDTO updateUser(UserDTO userDTO,Integer id) {
       User user1 = userRepository.findById(id).get();
       user1.setName(userDTO.getName());
       user1.setEmail(userDTO.getEmail());
       User saved=userRepository.save(user1);
        return modelMapper.map(saved, UserDTO.class);

    }
    @Override
    public String deleteUser(Integer id) {
        userRepository.deleteById(id);
        return "Deleted User with id " + id;
    }
}
