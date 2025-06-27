package com.ecommerce_backend.Dto.Response;

import java.util.List;

public class JwtResponseDto {

    private String token;
    private String type = "Bearer";
    private String email;

    private List<String> roles;

    public JwtResponseDto() {

    }

    public JwtResponseDto(String token, String email, List<String> roles) {
        this.token = token;
        this.email = email;
        this.roles=roles;
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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
