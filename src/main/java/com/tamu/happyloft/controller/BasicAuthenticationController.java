package com.tamu.happyloft.controller;

import com.tamu.happyloft.model.AuthenticationBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by arshi on 3/26/2020.
 */
@RestController
public class BasicAuthenticationController {

    @GetMapping(path = "/basicauth")
    public AuthenticationBean authenticate() {
        //throw new RuntimeException("Some Error has Happened! Contact Support at ***-***");
        System.out.println("here it is ");
        return new AuthenticationBean("You are authenticated");
    }
}