package com.vinsguru.aggregator.controller.advice;

import io.grpc.StatusRuntimeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(StatusRuntimeException.class)
    public ResponseEntity<String> handleException(StatusRuntimeException exception) {
        return switch (exception.getStatus().getCode()) {
            case INVALID_ARGUMENT, FAILED_PRECONDITION
                    -> ResponseEntity.badRequest().body(exception.getStatus().getDescription());
            case NOT_FOUND
                    -> ResponseEntity.notFound().build();
            default
                    -> ResponseEntity.internalServerError().body(exception.getMessage());
        };
    }
}
