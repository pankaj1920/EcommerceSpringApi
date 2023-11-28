package com.example.ecommerceapi.exception;


import com.example.ecommerceapi.model.request.auth.CreateAccountRequest;
import com.example.ecommerceapi.model.response.validation.ValidationError;
import com.example.ecommerceapi.utils.Print;
import com.example.ecommerceapi.utils.apiResponse.ApiResponse;
import com.example.ecommerceapi.utils.apiResponse.ErrorResponse;
import com.example.ecommerceapi.utils.apiResponse.ResponseHandler;
import com.example.ecommerceapi.utils.apiResponse.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse> handleMessageNotReadableException(HttpMessageNotReadableException exception) {

        Print.log("Exception "+exception);
        Print.log("Exception getMessage => "+exception.getMessage());
        Print.log("Exception getMostSpecificCause => "+exception.getMostSpecificCause());
        Print.log("Exception getMostSpecificCause Message => "+exception.getMostSpecificCause().getMessage());
        Print.log("Exception getLocalizedMessage => "+exception.getLocalizedMessage());
        Print.log("Exception getHttpInputMessage => "+exception.getHttpInputMessage());
        Print.log("Exception getCause => "+exception.getCause());
        Print.log("Exception getCause message=> "+exception.getCause().getMessage());
        Print.log("Exception fillInStackTrace => "+exception.fillInStackTrace().getMessage());
        Print.log("Exception getStackTrace=> "+ Arrays.toString(exception.getStackTrace()));

        ErrorResponse errorResponse = new ErrorResponse(exception.getMostSpecificCause().getMessage()
                , HttpStatus.BAD_REQUEST.value());
        return ResponseHandler.sendResponse(errorResponse);
    }
}
