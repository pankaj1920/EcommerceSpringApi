package com.example.ecommerceapi.service;

import com.example.ecommerceapi.model.request.auth.CreateAccountRequest;
import com.example.ecommerceapi.model.request.auth.CreateProfileRequest;
import com.example.ecommerceapi.utils.apiResponse.ApiResponse;

public interface AuthService{

    ApiResponse createAccount(CreateAccountRequest accountRequest);

    ApiResponse createProfile(CreateProfileRequest createProfileRequest);

}
