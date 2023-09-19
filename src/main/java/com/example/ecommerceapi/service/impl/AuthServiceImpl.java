package com.example.ecommerceapi.service.impl;

import com.example.ecommerceapi.model.entites.ApiStatus;
import com.example.ecommerceapi.model.entites.UserSchema;
import com.example.ecommerceapi.model.request.auth.CreateAccountRequest;
import com.example.ecommerceapi.model.request.auth.CreateProfileRequest;
import com.example.ecommerceapi.model.response.auth.CreateProfileResponse;
import com.example.ecommerceapi.repositories.AuthRepo;
import com.example.ecommerceapi.service.AuthService;
import com.example.ecommerceapi.utils.Print;
import com.example.ecommerceapi.utils.RandomUtils;
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

    AuthRepo authRepo;
    PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(AuthRepo authRepo, PasswordEncoder passwordEncoder) {
        this.authRepo = authRepo;
        this.passwordEncoder = passwordEncoder;
    }

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

    @Override
    public ApiResponse createProfile(CreateProfileRequest profileReq) {
        boolean isUserAlreadyExist = this.authRepo.findByEmail(profileReq.getEmail()).isPresent();

        if (!isUserAlreadyExist)
            return new ErrorResponse("User not found",HttpStatus.BAD_REQUEST.value());

       String otp = RandomUtils.generateOTP(6);

        UserSchema userInfo = new UserSchema();
        userInfo.setFirstName(profileReq.getFirstName());
        userInfo.setLastName(profileReq.getLastName());
        userInfo.setDob(profileReq.getDob());
        userInfo.setCountryCode(profileReq.getCountryCode());
        userInfo.setMobile(profileReq.getMobile());
        userInfo.setGender(profileReq.getGender());
        userInfo.setOtp(otp);
        userInfo.setUpdatedAt(new Date());
        this.authRepo.save(userInfo);
        return new SuccessResponse<>("Otp sent successfully", new CreateProfileResponse(otp), HttpStatus.OK.value());
    }
}
