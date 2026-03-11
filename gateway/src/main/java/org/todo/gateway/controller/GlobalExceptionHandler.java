package org.todo.gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.todo.gateway.exception.ToOldEndDateException;
import org.todo.gateway.model.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ToOldEndDateException.class)
    public ResponseEntity<ErrorResponse> handleToOldEndDateException(ToOldEndDateException e) {
        return ResponseEntity
                .badRequest()
                .body(new ErrorResponse(e.getMessage()));
    }
}
