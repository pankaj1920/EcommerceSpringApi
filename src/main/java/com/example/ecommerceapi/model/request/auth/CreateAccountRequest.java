package com.example.ecommerceapi.model.request.auth;

import com.example.ecommerceapi.utils.RegexPattern;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateAccountRequest {
    @NotEmpty(message = "Email cannot be empty")
    @Pattern(regexp = RegexPattern.Email, message = "Invalid email format")
    private String email;


    @NotEmpty(message = "Password cannot be empty")
    @Pattern(regexp = RegexPattern.Password, message = "Password should contain 1 uppercase, 1 number, 1 symbol, and should be 8 to 16 characters long")
    private String password;



}
