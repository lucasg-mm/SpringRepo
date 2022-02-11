package net.javaguides.springbootcrudrestfulwebservices.controller;

import net.javaguides.springbootcrudrestfulwebservices.entity.User;
import net.javaguides.springbootcrudrestfulwebservices.exception.ResourceNotFoundException;
import net.javaguides.springbootcrudrestfulwebservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // get users
    @GetMapping
    public List<User> getAllUsers() {
        System.out.println("WTH is going on");
        return userRepository.findAll();
    }

    // get user by id
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    }

    // save user
    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    // update user
    @PutMapping("/{userId}")
    public User updateUser(@RequestBody User user, @PathVariable long userId){
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());

        return userRepository.save(existingUser);
    }

    // delete user by id
    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable long userId){
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        userRepository.delete(existingUser);

        return ResponseEntity.ok().build();
    }
}
