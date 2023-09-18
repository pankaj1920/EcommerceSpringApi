package com.example.ecommerceapi.utils.apiResponse;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse extends ApiResponse {


    public ErrorResponse(String msg,int statusCode) {
        super(false,statusCode, msg);
    }

    public ErrorResponse(boolean status,String message,int statusCode) {
        super(status, statusCode,message);
    }
}
