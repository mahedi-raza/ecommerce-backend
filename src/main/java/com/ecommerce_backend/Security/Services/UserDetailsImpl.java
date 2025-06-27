package com.ecommerce_backend.Security.Services;

import com.ecommerce_backend.Entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {


    private Long id;
    private String email;
    private String password;

    private Collection<? extends GrantedAuthority> grantedAuthorities;


    public UserDetailsImpl(Long id, String email, String password, Collection<? extends GrantedAuthority> grantedAuthorities) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.grantedAuthorities = grantedAuthorities;
    }


    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> grantedAuthorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(user.getUserId(), user.getEmail(), user.getPassword(), grantedAuthorities);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public Long getId() {
        return id;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
