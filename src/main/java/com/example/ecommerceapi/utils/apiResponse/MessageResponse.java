package com.example.ecommerceapi.utils.apiResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponse extends ApiResponse {

    public MessageResponse(String message,int statusCode) {
        super(true,statusCode, message);
    }

    public MessageResponse(boolean status, String message,int statusCode) {
        super(status, statusCode,message);
    }
}
