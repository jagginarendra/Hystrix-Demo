package com.demo.sapient.exception;

public class NoProductFoundException extends RuntimeException {

    public NoProductFoundException(String message) {
        super(message);
    }
}
