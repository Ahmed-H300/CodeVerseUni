package com.codeverse.code_verse_uni.controller;

import com.codeverse.code_verse_uni.exception.EntityNotFoundException;
import com.codeverse.code_verse_uni.response.EntityErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class EntityRestExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class, NoHandlerFoundException.class})
    public ResponseEntity<EntityErrorResponse> handleExceptions(Exception exc) {

        // Create an EntityErrorResponse
        EntityErrorResponse error = new EntityErrorResponse();
        error.setStatus("404");
        error.setMessage(exc.getMessage());

        // Convert timestamp to a more human-readable format
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = currentTime.format(formatter);
        error.setTimeStamp(formattedTime);

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EntityErrorResponse> handleException(Exception exc){

            // create a StudentErrorResponse
            EntityErrorResponse error = new EntityErrorResponse();

            error.setStatus("400");
            error.setMessage(exc.getMessage());
            // Convert timestamp to a more human-readable format
            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedTime = currentTime.format(formatter);
            error.setTimeStamp(formattedTime);

            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
