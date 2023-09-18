package com.example.ecommerceapi.controller;

import com.example.ecommerceapi.exception.ApiValidationException;
import com.example.ecommerceapi.model.request.auth.CreateAccountRequest;
import com.example.ecommerceapi.service.AuthService;
import com.example.ecommerceapi.utils.apiResponse.ApiResponse;
import com.example.ecommerceapi.utils.apiResponse.ResponseHandler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.ecommerceapi.validation.auth.AuthValidation.isRegisterValid;

@RestController
@RequestMapping("api/auth/")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("register")
    public ResponseEntity<ApiResponse> userRegister(
            @RequestBody CreateAccountRequest createAccountRequest
    ) throws ApiValidationException {
        isRegisterValid(createAccountRequest);
        ApiResponse createAccountResponse = authService.createAccount(createAccountRequest);
        return ResponseHandler.sendResponse(createAccountResponse);
    }
}
