package com.ecommerce_backend.Service.Impl;

import com.ecommerce_backend.Dto.Request.UserRequestDto;
import com.ecommerce_backend.Dto.Response.UserResponseDto;
import com.ecommerce_backend.Entity.User;
import com.ecommerce_backend.Mapper.UserMapper;
import com.ecommerce_backend.Repository.UserRepository;
import com.ecommerce_backend.Service.UserService;
import com.ecommerce_backend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;


    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = userMapper.toEntity(userRequestDto);
        return userMapper.toDto(userRepository.save(user));
    }


    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper ::toDto).toList();
    }


    @Override
    public UserResponseDto updateUser(Long userId, UserRequestDto userRequestDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());

        User updatedUser = userRepository.save(user);
        return userMapper.toDto(updatedUser);
    }


    @Override
    public UserResponseDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found!"));
        return userMapper.toDto(user);
    }


    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

}
