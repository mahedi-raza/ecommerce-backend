package com.ecommerce_backend.Controller;

import com.ecommerce_backend.Dto.Request.LoginRequestDto;
import com.ecommerce_backend.Dto.Request.RegisterRequestDto;
import com.ecommerce_backend.Dto.Response.JwtResponseDto;
import com.ecommerce_backend.Dto.Response.UserResponseDto;
import com.ecommerce_backend.Entity.User;
import com.ecommerce_backend.Mapper.UserMapper;
import com.ecommerce_backend.Security.Jwt.JwtUtils;
import com.ecommerce_backend.Security.Services.UserDetailsImpl;
import com.ecommerce_backend.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserMapper userMapper;


    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody RegisterRequestDto registerRequestDto){
        User user = authService.registerUser(registerRequestDto);
        return ResponseEntity.ok(userMapper.toDto(user));
    }


    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(), loginRequestDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        return ResponseEntity.ok(new JwtResponseDto(token, userDetails.getUsername(), roles));
    }
}
