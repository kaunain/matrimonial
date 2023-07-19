package com.itechf.backend;

import org.modelmapper.ModelMapper;
import org.openapitools.model.User;
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

    public List<User> getAllUsers() {
        List<UserEntity> userList = userRepository.findAll();
        List<User> userDTOList = userList.stream()
            .map(userEntity -> modelMapper.map(userEntity, User.class))
            .collect(Collectors.toList());
        return userDTOList;
    }

    public User createUser(User user) {
        UserEntity userEntity = userRepository.save(modelMapper.map(user, UserEntity.class));
        return modelMapper.map(userEntity, User.class);
    }

    public User getUserById(Long userId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return null;
        }
        return modelMapper.map(user, User.class);
    }

    public User updateUser(Long userId, User updatedUser) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            // Handle user not found case, such as throwing an exception or returning null/error response
        }

        // Update the user with non-null values from the updatedUser
        if (updatedUser.getName() != null) {
            user.setName(updatedUser.getName());
        }
        if (updatedUser.getAge() != null) {
            user.setAge(updatedUser.getAge());
        }
        if (updatedUser.getGender() != null) {
            user.setGender(updatedUser.getGender());
        }

        // Save the updated user
        return modelMapper.map(userRepository.save(user), User.class);
    }
}
