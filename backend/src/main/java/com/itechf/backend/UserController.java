package com.itechf.backend;

import org.openapitools.api.UsersApi;
import org.openapitools.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController implements UsersApi{

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUserById(@PathVariable Long userId, @RequestBody User updatedUser) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        // Update the user with the new data
        if(updatedUser.getName() != null)
            user.setName(updatedUser.getName());
        if(updatedUser.getAge() != null)
            user.setAge(updatedUser.getAge());
        if(updatedUser.getGender() != null)
        user.setGender(updatedUser.getGender());

        User savedUser = userService.updateUser(user);
        return ResponseEntity.ok(savedUser);
    }
}
