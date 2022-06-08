package com.azadi.exception;

import com.azadi.controller.ProductGroupController;
import org.hibernate.LazyInitializationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductGroupController.class);

    @ExceptionHandler(value = { IOException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CustomErrorResponse badRequest(Exception ex)
    {
        return new CustomErrorResponse(400, "Bad Request", LocalDateTime.now());
    }

    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomErrorResponse unKnownException(Exception ex)
    {
        return new CustomErrorResponse(404, "Employee Not Found",LocalDateTime.now());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NoSuchElementException.class , LazyInitializationException.class})
    public ResponseEntity<CustomErrorResponse> return404(NoSuchElementException ex) {
        LOGGER.error("Unable to complete transaction", ex);
        CustomErrorResponse error = new CustomErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(),LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }
}
