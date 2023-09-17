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
    public SuccessResponse(boolean status, String message, T data) {
        super(status, message);
        this.data = data;
    }

    private T data;
}
