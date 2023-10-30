package com.example.controller;

import com.example.body.UserRegistration;
import com.example.body.UserResponseBody;
import com.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void save(@RequestBody UserRegistration userRegistration) {
        userService.save(userRegistration);
    }

    @GetMapping
    public List<UserResponseBody> findAll() {
        return userService.findAll();
    }
}
