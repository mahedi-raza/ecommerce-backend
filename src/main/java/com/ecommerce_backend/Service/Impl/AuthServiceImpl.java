package com.ecommerce_backend.Service.Impl;

import com.ecommerce_backend.Dto.Request.RegisterRequestDto;
import com.ecommerce_backend.Entity.Role;
import com.ecommerce_backend.Entity.User;
import com.ecommerce_backend.Enum.ERole;
import com.ecommerce_backend.Repository.RoleRepository;
import com.ecommerce_backend.Repository.UserRepository;
import com.ecommerce_backend.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public User registerUser(RegisterRequestDto registerRequestDto) {
        User user = new User();
        user.setName(registerRequestDto.getName());
        user.setEmail(registerRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));

        Set<Role roles = new HashSet<>();

        if (registerRequestDto.getRoles() == null || registerRequestDto.getRoles().isEmpty()) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(()-> new RuntimeException("Error: Role 'User' not found"));
            roles.add(userRole);
        } else {
            for (String roleStr : registerRequestDto.getRoles()){
                switch (roleStr.toLowerCase()) {
                    case "admin" -> roles.add(roleRepository.findByName(ERole.ROLE_ADMIN)
                            .orElseThrow(()-> new RuntimeException("Error: Role 'Admin' not found"));
                    case "user" -> roles.add(roleRepository.findByName(ERole.ROLE_USER)
                            .orElseThrow(()-> new RuntimeException("Error: Role 'User' not found")));
                    default -> throw new RuntimeException("Error: Invalid role name");
                }
            }
        }

        user.setRoles(roles);
        return userRepository.save(user);
    }
}
