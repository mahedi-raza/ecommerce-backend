package com.ecommerce_backend.Service;

import com.ecommerce_backend.Dto.Request.UserRequestDto;
import com.ecommerce_backend.Dto.Response.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto createUser(UserRequestDto userRequestDto);

    List<UserResponseDto> getAllUsers();

    UserResponseDto updateUser(Long userId, UserRequestDto requestDto);

    UserResponseDto getUserById(Long userId);

    void deleteUser(Long userId);
}
