package com.tamu.happyloft.controller;

import com.tamu.happyloft.dto.ResetPasswordDto;
import com.tamu.happyloft.model.User;
import com.tamu.happyloft.service.EmailService;
import com.tamu.happyloft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

/**
 * Created by arshi on 3/17/2020.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    EmailService emailService;

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

    @GetMapping(value = "/reset-password")
    public String sendEmailForgotPassword(@RequestParam String email) throws IOException, MessagingException {
        emailService.sendResetPasswordMessage(email);

        return "An email with password reset instructions has been sent to your email address.";
    }

    @PostMapping("/change-password")
    public String changePassword(@RequestBody ResetPasswordDto resetPasswordDto) {
        return userService.changePassword(resetPasswordDto);
    }

}
