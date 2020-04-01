package com.tamu.happyloft.service;

import com.tamu.happyloft.model.User;
import com.tamu.happyloft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by arshi on 3/31/2020.
 */
public abstract class AbstractHelperService {

    @Autowired
    protected UserRepository userRepository;

    protected User getUserByEmail(String email) {
        if(null == email || email.isEmpty()) {
            throw new RuntimeException("Email ID is missing");
        }
        List<User> existingUser = userRepository.findByEmail(email);
        if(!existingUser.isEmpty()) {
            return existingUser.get(0);
        }
        return null;
    }
}
