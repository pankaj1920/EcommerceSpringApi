package com.example.ecommerceapi.utils.apiResponse;

import com.example.dairyclub.utils.apiResponse.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> sendResponse(Boolean status, String message, HttpStatus statusCode, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status_code", statusCode.value());
        map.put("status", status);
        map.put("data", responseObj);

        return new ResponseEntity<>(map, statusCode);
    }

    private <T>SuccessResponse<T> getResponse() {
        SuccessResponse<T> successResponse = new SuccessResponse<>();
        successResponse.setStatus(true);
        successResponse.setMessage("Otp Sent succesfully");
        return successResponse;
    }
}