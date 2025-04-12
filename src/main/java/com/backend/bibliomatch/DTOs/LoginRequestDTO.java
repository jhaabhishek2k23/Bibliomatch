package com.backend.bibliomatch.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class LoginRequestDTO {

    @NotBlank(message = "Username or Email is required")
    @JsonProperty("emailOrUser") 
    private String usernameOrEmail;

    @NotBlank(message = "Password is required")
    private String password;
    
    
    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }


    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }


    public String getPassword() {
        return password;
    }

    
}
