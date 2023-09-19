package com.example.ecommerceapi.model.response.auth;

import com.example.ecommerceapi.model.other.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProfileResponse {
   private String otp;
}