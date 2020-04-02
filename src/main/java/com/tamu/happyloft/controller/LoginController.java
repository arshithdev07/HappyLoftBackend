package com.tamu.happyloft.controller;

import com.tamu.happyloft.dto.LoginDto;
import com.tamu.happyloft.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by arshi on 4/2/2020.
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping(value = "/user")
    public String loginUser(@RequestBody LoginDto loginDto) {
        return loginService.loginUser(loginDto);
    }
}
