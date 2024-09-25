package com.springreact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.springreact.model.User;
import com.springreact.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("http://localhost:3000")
public class UserController {

	@Autowired
    private UserService userService;

    @PostMapping("/login")
    public int login(@RequestBody User user) {
        return userService.login(user);
    }

}
