package com.book.inventory.exception;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public HttpEntity<ErrorResponseDto> handleNotFound(Exception ex) {

        return new ResponseEntity<>(new ErrorResponseDto(
                HttpStatus.NOT_FOUND.value(), ex.getMessage()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ BookIdMismatchException.class})
    public ResponseEntity<Object> handleBadRequest(
            Exception ex) {
        return new ResponseEntity<>(new ErrorResponseDto(
                HttpStatus.BAD_REQUEST.value(), ex.getMessage()),
                HttpStatus.NOT_FOUND);
    }
}
