package mongodb.com.mongodb_project.controller;


import com.mongodb.lang.NonNull;
import mongodb.com.mongodb_project.model.User;
import mongodb.com.mongodb_project.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userRepository.findById(id).orElseGet(null);
    }

    @GetMapping("/name")
    public User getUserByName(@NonNull @RequestParam String name) {
        return userRepository.findByName(name);
    }

    @GetMapping("/age")
    public User getUserByMinAge(@NonNull @RequestParam Integer age) {
        return userRepository.findByMinAge(age);
    }
}
