package com.tamu.happyloft.service;

import com.tamu.happyloft.dto.LoginDto;
import com.tamu.happyloft.model.User;
import com.tamu.happyloft.service.constants.UserType;
import org.springframework.stereotype.Service;

/**
 * Created by arshi on 4/2/2020.
 */
@Service
public class LoginService extends AbstractHelperService{

    public String loginUser(LoginDto loginDto) {

        User existingUser = getUserByEmail(loginDto.getEmail());

        if(null == existingUser) {
            throw new RuntimeException("User Record doesn't exist");
        }

        if(!existingUser.getPassword().equals(loginDto.getPassword())) {
            throw new RuntimeException("Incorrect email or password");
        }

        if(loginDto.getEmail().equals("admin@happyloft.com") && loginDto.getPassword().equals("Admin!23")) {
            return UserType.ADMIN;
        }

        return UserType.USER;

    }
}
