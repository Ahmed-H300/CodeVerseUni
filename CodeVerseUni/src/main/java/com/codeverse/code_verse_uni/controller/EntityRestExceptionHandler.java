package com.codeverse.code_verse_uni.controller;

import com.codeverse.code_verse_uni.exception.EntityNotFoundException;
import com.codeverse.code_verse_uni.response.EntityErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EntityRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EntityErrorResponse> handleException(EntityNotFoundException exc) {

        // create a StudentErrorResponse
        EntityErrorResponse error = new EntityErrorResponse();

        error.setStatus("404");
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EntityErrorResponse> handleException(Exception exc){

            // create a StudentErrorResponse
            EntityErrorResponse error = new EntityErrorResponse();

            error.setStatus("400");
            error.setMessage(exc.getMessage());
            error.setTimeStamp(System.currentTimeMillis());

            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
