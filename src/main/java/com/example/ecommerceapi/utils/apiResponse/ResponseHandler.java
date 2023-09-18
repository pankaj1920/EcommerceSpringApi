package com.example.ecommerceapi.utils.apiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> sendResponse(Boolean status, String message, HttpStatus statusCode, Object responseObj) {
        Map<String, Object> map = new HashMap();
        map.put("message", message);
        map.put("status_code", statusCode.value());
        map.put("status", status);
        map.put("data", responseObj);

        return new ResponseEntity<>(map, statusCode);
    }

    public static ResponseEntity<ApiResponse> sendResponse(ApiResponse apiResponse) {
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatusCode()));
    }
}