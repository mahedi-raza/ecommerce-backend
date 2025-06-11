package com.ecommerce_backend.Mapper;

import com.ecommerce_backend.Dto.Request.UserRequestDto;
import com.ecommerce_backend.Dto.Response.UserResponseDto;
import com.ecommerce_backend.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequestDto userRequestDto) {
        User user = new User();
        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        return user;
    }

    public UserResponseDto toDto(User user) {
        UserResponseDto categoryResponseDto = new UserResponseDto();
        categoryResponseDto.setUserId(user.getUserId());
        categoryResponseDto.setName(user.getName());
        categoryResponseDto.setEmail(user.getEmail());
        return categoryResponseDto;
    }
}
