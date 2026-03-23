package com.esiee.project.api.controller;

import org.springframework.web.bind.annotation.*;
import com.esiee.project.application.service.UserService;
import com.esiee.project.domain.entity.User;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
