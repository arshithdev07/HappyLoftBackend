package com.tamu.happyloft.service;

import com.tamu.happyloft.model.User;
import com.tamu.happyloft.repository.UserRepository;
import com.tamu.happyloft.service.exceptions.DuplicateRecordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by arshi on 3/17/2020.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User addUser(User user) {
        List<User> existingUser = userRepository.findByEmail(user.getEmail());
        if(!existingUser.isEmpty()) {
            throw new DuplicateRecordException("User with this Email ID already exists");
        }
        return userRepository.save(user);
    }


}