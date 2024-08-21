package com.user.UserModule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.UserModule.model.Users;
import com.user.UserModule.service.JwtService;
import com.user.UserModule.service.UserService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(path = "/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtService jwtService;
    
    @GetMapping(path = "/api/allusers")
    public Iterable<Users> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @PostMapping(path = "/api/login")
    public String login(@RequestBody Users user) {
        String username = user.getUsername();
        String password = user.getPassword();
        
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));
        
        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        } else {
            return "Failure";
        }
    }

    @PostMapping(path = "/api/addusers")
    public Users createUser(@RequestBody Users users) {
        return userService.saveUser(users); 
    }

    @GetMapping(path = "/api/users")
    public List<Users> getUsersByFirstName(@RequestParam String firstName) {
        return userService.getUsersByFirstName(firstName);
    }
}
