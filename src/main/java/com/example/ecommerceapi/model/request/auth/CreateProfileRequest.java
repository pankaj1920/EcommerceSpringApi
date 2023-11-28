package com.example.ecommerceapi.model.request.auth;

import com.example.ecommerceapi.exception.ApiValidationException;
import com.example.ecommerceapi.model.other.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CreateProfileRequest {
    private String firstName;
    private String lastName;
    private Date dob;
    private int countryCode;
    private int mobile;
    private String email;
    private Gender gender;
    private Date updatedAt;
}
