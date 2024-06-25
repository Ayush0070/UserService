package com.example.userservice.services;

import com.example.userservice.models.Token;
import com.example.userservice.models.User;
import com.example.userservice.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserRepository userRepository;

    UserService(BCryptPasswordEncoder bCryptPasswordEncoder,
                UserRepository userRepository){
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }

    public User signUp(String name, String email, String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setHassedPassword(bCryptPasswordEncoder.encode(password));
        user.setEmailVerified(true);

        //Save the user object to DB
        return userRepository.save(user);
    }

    public Token login(String email, String password) {
        return null;
    }

    public void logout(String token) {
        return;
    }

    public User validateToken(String token) {
        return null;
    }
}

