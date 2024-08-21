package com.user.UserModule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.UserModule.model.Users;
import com.user.UserModule.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public Iterable<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users saveUser(Users users) {
        return userRepository.save(users);
    }

    public List<Users> getUsersByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }
}
