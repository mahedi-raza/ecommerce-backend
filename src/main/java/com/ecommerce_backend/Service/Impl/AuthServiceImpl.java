package com.ecommerce_backend.Service.Impl;

import com.ecommerce_backend.Dto.Request.RegisterRequestDto;
import com.ecommerce_backend.Entity.User;
import com.ecommerce_backend.Repository.UserRepository;
import com.ecommerce_backend.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public User registerUser(RegisterRequestDto registerRequestDto) {
        User user = new User();
        user.setName(registerRequestDto.getName());
        user.setEmail(registerRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));
        return userRepository.save(user);
    }
}
