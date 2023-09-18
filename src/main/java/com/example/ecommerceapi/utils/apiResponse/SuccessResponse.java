package com.example.ecommerceapi.utils.apiResponse;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuccessResponse<T> extends ApiResponse {
    public SuccessResponse(String message, T data,int statusCode) {
        super(true,statusCode, message);
        this.data = data;
    }

    public SuccessResponse(boolean status, String message, T data,int statusCode) {
        super(status,statusCode, message);
        this.data = data;
    }

    private T data;
}
