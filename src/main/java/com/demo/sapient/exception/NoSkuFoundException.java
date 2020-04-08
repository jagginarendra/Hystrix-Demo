package com.demo.sapient.exception;

public class NoSkuFoundException extends RuntimeException {

    public NoSkuFoundException(String message) {
        super(message);
    }
}
