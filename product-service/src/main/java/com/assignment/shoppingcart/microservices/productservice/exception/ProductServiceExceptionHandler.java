package com.assignment.shoppingcart.microservices.productservice.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ProductServiceExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ApiError> handleProductNotFoundException(ProductNotFoundException ex, WebRequest request) {
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), ex.getMessage(), new Date());
		return new ResponseEntity<ApiError>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<ApiError> handleAllExceptions(Exception ex, WebRequest request) {
		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), ex.getMessage(),
				new Date());
		return new ResponseEntity<ApiError>(apiError, new HttpHeaders(), apiError.getStatus());
	}

}
