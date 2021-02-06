package com.book.inventory.exception;

public class BookIdMismatchException extends RuntimeException {

    public BookIdMismatchException(String message) {

        super(message);
    }
}
