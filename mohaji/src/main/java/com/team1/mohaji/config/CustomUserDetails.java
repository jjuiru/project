package com.team1.mohaji.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


@Getter
@Setter
public class CustomUserDetails implements UserDetails {


    private String email;
    private String name;
    private int memberId;  // 사용자 ID
    private String username;
    private String password;
    private String role;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(String email, String name, int memberId, String username,
                             String password, String role, Collection<? extends GrantedAuthority> authorities) {
        this.email = email;
        this.name = name;
        this.memberId = memberId;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getRole(){ return role; }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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