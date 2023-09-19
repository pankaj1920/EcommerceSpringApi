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

    public void setUpdatedAt(Date updatedAt) throws ApiValidationException {
        // Custom validation logic for the updatedAt field
        if (updatedAt == null) {
            this.updatedAt = null;
        } else if (isValidDate(updatedAt)) {
            this.updatedAt = updatedAt;
        } else {
            // Throw a custom exception with an error message
            throw new ApiValidationException("Invalid date format for updatedAt");
        }
    }

    // Helper method to check if a Date is valid
    private boolean isValidDate(Date date) {

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            dateFormat.parse(date.toString());
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
