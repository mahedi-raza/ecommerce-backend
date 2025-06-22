package com.ecommerce_backend.Dto.Response;

public class JwtResponseDto {

    private String token;
    private String type = "Bearer";
    private String email;

    public JwtResponseDto() {

    }

    public JwtResponseDto(String token, String email) {
        this.token = token;
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public String getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }
}
