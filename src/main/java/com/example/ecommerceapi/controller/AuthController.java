package com.example.ecommerceapi.controller;

import com.example.ecommerceapi.exception.ApiValidationException;
import com.example.ecommerceapi.model.request.auth.CreateAccountRequest;
import com.example.ecommerceapi.model.request.auth.CreateProfileRequest;
import com.example.ecommerceapi.service.AuthService;
import com.example.ecommerceapi.utils.apiResponse.ApiResponse;
import com.example.ecommerceapi.utils.apiResponse.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.ecommerceapi.validation.auth.AuthValidation.isRegisterValid;

@RestController
@RequestMapping("api/auth/")
public class AuthController {
    AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("register")
    public ResponseEntity<ApiResponse> userRegister(
            @RequestBody CreateAccountRequest createAccountRequest
    ) throws ApiValidationException {
        isRegisterValid(createAccountRequest);
        ApiResponse createAccountResponse = authService.createAccount(createAccountRequest);
        return ResponseHandler.sendResponse(createAccountResponse);
    }


    @PostMapping("create_profile")
    public ResponseEntity<ApiResponse> createProfile(
            @RequestBody CreateProfileRequest profileRequest
    ) throws ApiValidationException {

        ApiResponse createProfileResponse = authService.createProfile(profileRequest);
        return ResponseHandler.sendResponse(createProfileResponse);
    }


}
