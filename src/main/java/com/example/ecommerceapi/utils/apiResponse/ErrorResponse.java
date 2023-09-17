package com.example.ecommerceapi.utils.apiResponse;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse extends ApiResponse {
    private boolean status;
    private String message;
}
