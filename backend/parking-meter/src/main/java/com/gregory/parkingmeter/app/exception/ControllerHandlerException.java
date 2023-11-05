package com.gregory.parkingmeter.app.exception;

import com.gregory.parkingmeter.domain.exception.CalculateTimeExpirationException;
import com.gregory.parkingmeter.domain.exception.DataIntegrityException;
import com.gregory.parkingmeter.domain.exception.DataNullOrEmptyException;
import com.gregory.parkingmeter.domain.exception.InsufficientBalanceException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ControllerHandlerException {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<StandardError> badRequestException(BadRequestException ex,
                                                             HttpServletRequest request) {
        return ResponseEntity.status(BAD_REQUEST).body(StandardError.builder()
                .dateTime(LocalDateTime.now())
                .status(BAD_REQUEST.value())
                .error(ex.getMessage())
                .path(request.getRequestURI())
                .build());
    }

    @ExceptionHandler(DataNullOrEmptyException.class)
    public ResponseEntity<StandardError> dataNullOrEmptyException(DataNullOrEmptyException ex,
                                                                  HttpServletRequest request) {
        return ResponseEntity.status(NOT_FOUND).body(StandardError.builder()
                .dateTime(LocalDateTime.now())
                .status(NOT_FOUND.value())
                .error(ex.getMessage())
                .path(request.getRequestURI())
                .build());
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> dataIntegrityException(DataIntegrityException ex,
                                                                HttpServletRequest request) {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(StandardError.builder()
                .dateTime(LocalDateTime.now())
                .status(INTERNAL_SERVER_ERROR.value())
                .error(ex.getMessage())
                .path(request.getRequestURI())
                .build());
    }

    @ExceptionHandler(CalculateTimeExpirationException.class)
    public ResponseEntity<StandardError> calculateException(CalculateTimeExpirationException ex,
                                                            HttpServletRequest request) {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(StandardError.builder()
                .dateTime(LocalDateTime.now())
                .status(INTERNAL_SERVER_ERROR.value())
                .error(ex.getMessage())
                .path(request.getRequestURI())
                .build());
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<StandardError> insufficientBalanceException(InsufficientBalanceException ex,
                                                            HttpServletRequest request) {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(StandardError.builder()
                .dateTime(LocalDateTime.now())
                .status(INTERNAL_SERVER_ERROR.value())
                .error(ex.getMessage())
                .path(request.getRequestURI())
                .build());
    }

}
