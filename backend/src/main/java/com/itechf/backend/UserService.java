package com.itechf.backend;

import org.modelmapper.ModelMapper;
import org.openapitools.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = userList.stream()
            .map(user -> modelMapper.map(user, UserDTO.class))
            .collect(Collectors.toList());
        return userDTOList;
    }

    public UserDTO createUser(UserDTO user) {
        User userEntity = userRepository.save(modelMapper.map(user, User.class));
        return modelMapper.map(userEntity, UserDTO.class);
    }

    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return null;
        }
        return modelMapper.map(user, UserDTO.class);
    }

    public UserDTO updateUser(Long userId, UserDTO updatedUser) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            // Handle user not found case, such as throwing an exception or returning null/error response
        }

        // Update the user with non-null values from the updatedUser
        if (updatedUser.getName() != null) {
            user.setName(updatedUser.getName());
        }
        

        // Save the updated user
        return modelMapper.map(userRepository.save(user), UserDTO.class);
    }
}
