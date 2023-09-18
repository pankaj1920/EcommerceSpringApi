package com.example.ecommerceapi.exception;


import com.example.ecommerceapi.model.request.auth.CreateAccountRequest;
import com.example.ecommerceapi.model.response.validation.ValidationError;
import com.example.ecommerceapi.utils.apiResponse.ApiResponse;
import com.example.ecommerceapi.utils.apiResponse.ErrorResponse;
import com.example.ecommerceapi.utils.apiResponse.ResponseHandler;
import com.example.ecommerceapi.utils.apiResponse.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

/*    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException exception){
        String message = exception.getMessage();
        ApiResponse apiResponse = new ApiResponse(false,message);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }*/

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleMethodArgsNotValidException(MethodArgumentNotValidException exception) {
        ArrayList<String> list = new ArrayList<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            list.add(error.getDefaultMessage());
        });


        ValidationError validationError = new ValidationError(list);

        SuccessResponse<ValidationError> errorResponse = new SuccessResponse<>(false, "Validation failed", validationError, HttpStatus.BAD_REQUEST.value());
        return ResponseHandler.sendResponse(errorResponse);
    }

    @ExceptionHandler(ApiValidationException.class)
    public ResponseEntity<ApiResponse> handleCustomApiValidation(ApiValidationException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseHandler.sendResponse(errorResponse);
    }
}
