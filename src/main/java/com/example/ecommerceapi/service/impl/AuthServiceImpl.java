package com.example.ecommerceapi.service.impl;

import com.example.ecommerceapi.model.entites.ApiStatus;
import com.example.ecommerceapi.model.entites.UserSchema;
import com.example.ecommerceapi.model.request.auth.CreateAccountRequest;
import com.example.ecommerceapi.repositories.AuthRepo;
import com.example.ecommerceapi.service.AuthService;
import com.example.ecommerceapi.utils.apiResponse.ApiResponse;
import com.example.ecommerceapi.utils.apiResponse.ErrorResponse;
import com.example.ecommerceapi.utils.apiResponse.MessageResponse;
import com.example.ecommerceapi.utils.apiResponse.SuccessResponse;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthRepo authRepo;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public ApiResponse createAccount(CreateAccountRequest accountRequest) {
        boolean isUserAlreadyExist = this.authRepo.findByEmail(accountRequest.getEmail()).isPresent();
        if (isUserAlreadyExist) {
            return new ErrorResponse("User Already Exist", HttpStatus.IM_USED.value());
        }
        UserSchema user = new UserSchema();
        user.setEmail(accountRequest.getEmail());
        user.setPassword(passwordEncoder.encode(accountRequest.getPassword()));
        Date currentDate = new Date();
        user.setCreatedAt(currentDate);
        user.setUpdatedAt(currentDate);
        ApiStatus apiStatus = new ApiStatus();
        apiStatus.setStatus(false);
        apiStatus.setId(user.getId());
        user.setApiStatus(apiStatus);
        this.authRepo.save(user);
        return new MessageResponse("User register successfully", HttpStatus.OK.value());
    }
}
