package com.itechf.backend;

import org.openapitools.model.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();
    private Long userIdCounter = 1L;

    public List<User> getAllUsers() {
        return users;
    }

    public User createUser(User user) {
        user.setId(userIdCounter);
        users.add(user);
        userIdCounter++;
        return user;
    }

    public User getUserById(Long userId) {
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public User updateUser(User user) {
        // No additional logic required for this example
        return user;
    }
}
