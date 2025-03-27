package mongodb.com.mongodb_project.controller;


import com.mongodb.lang.NonNull;
import mongodb.com.mongodb_project.app.event.handling.MyEventPublisher;
import mongodb.com.mongodb_project.model.User;
import mongodb.com.mongodb_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    MyEventPublisher publisher;

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        User save = userRepository.save(user);
        publisher.publishEventMessage("User with name " + user.getName() + " will be saved");
        return save;
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
