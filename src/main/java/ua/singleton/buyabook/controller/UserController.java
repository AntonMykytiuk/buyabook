package ua.singleton.buyabook.controller;

import org.springframework.web.bind.annotation.*;
import ua.singleton.buyabook.model.User;
import ua.singleton.buyabook.service.UserService;

import java.util.List;

@RestController
@RequestMapping("rest/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.create(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.removeById(id);
    }
}
