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
public class UserService extends AbstractHelperService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User addUser(User user) {

        User existingUser = getUserByEmail(user.getEmail());
        if(null != existingUser) {
            throw new DuplicateRecordException("User with this Email ID already exists");
        }
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        User existingUser = getUserByEmail(user.getEmail());
        if(null == existingUser) {
            throw new RuntimeException("User Record doesn't exist");
        }
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setDob(user.getDob());
        existingUser.setBio(user.getBio());
        existingUser.setAddress(user.getAddress());
        existingUser.setContact(user.getContact());
        return userRepository.save(existingUser);
    }

    public User fetchUserDetails(String email) {
        User existingUser = getUserByEmail(email);
        if(null == existingUser) {
            throw new RuntimeException("User Record doesn't exist");
        }
        return existingUser;
    }



}