package com.example.ecommerceapi.validation.auth;

import com.example.ecommerceapi.exception.ApiValidationException;
import com.example.ecommerceapi.model.request.auth.CreateAccountRequest;
import com.example.ecommerceapi.model.request.auth.CreateProfileRequest;
import com.example.ecommerceapi.utils.RegexPattern;

import java.util.regex.Pattern;

public class AuthValidation {

    public static Boolean isRegisterValid(CreateAccountRequest request) throws ApiValidationException {
        boolean isValidEmail = Pattern.compile(RegexPattern.Email).matcher(request.getEmail()).matches();
        boolean isValidPassword = Pattern.compile(RegexPattern.Password).matcher(request.getPassword()).matches();
        if (request.getEmail().isEmpty()) {
            throw new ApiValidationException("Email cannot be is empty");
        } else if (!isValidEmail) {
            throw new ApiValidationException("Invalid email");
        } else if (request.getPassword().isEmpty()) {
            throw new ApiValidationException("Password cannot be is empty");
        } else if (!isValidPassword) {
            throw new ApiValidationException("Password must contain 1 uppercase 1 number 1 symbol and length must be in between 8 - 16");
        } else {
            return true;
        }

    }

    public static Boolean isCreateProfileValid(CreateProfileRequest request) throws  ApiValidationException{
        boolean isValidEmail = Pattern.compile(RegexPattern.Email).matcher(request.getEmail()).matches();

        if (request.getFirstName().isEmpty()){
            throw new ApiValidationException("First name cannot be empty");
        }else if (request.getLastName().isEmpty()){
            throw new ApiValidationException("Last name cannot be empty");
        }else if (request.getDob().toString().isEmpty()){
            throw new ApiValidationException("D.O.B cannot be empty");
        }

        return true;
    }


}
