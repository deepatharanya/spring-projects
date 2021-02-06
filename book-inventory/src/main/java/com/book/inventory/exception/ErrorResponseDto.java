package com.book.inventory.exception;

import lombok.Data;

@Data
public class ErrorResponseDto {

    private int status;

    private String message;

    public ErrorResponseDto(int status, String message) {

        this.status = status;
        this.message = message;
    }
}
