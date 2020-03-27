package com.tamu.happyloft.service;

import com.tamu.happyloft.model.User;
import com.tamu.happyloft.repository.UserRepository;
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

//    public User addUser(User user) {
//        return this.userRepository.save(user);
//    }

}