package com.ecommerce_backend.Service;

import com.ecommerce_backend.Dto.Request.RegisterRequestDto;
import com.ecommerce_backend.Entity.User;

public interface AuthService {

    User registerUser(RegisterRequestDto registerRequestDto);
}
