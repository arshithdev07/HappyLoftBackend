package com.tamu.happyloft.controller;

import com.tamu.happyloft.model.User;
import com.tamu.happyloft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by arshi on 3/17/2020.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(value = "/add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping(value = "/update")
    public User update(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @GetMapping(value = "/fetch")
    public User fetchUserDetails(@RequestParam String email) {
        return userService.fetchUserDetails(email);
    }

}
