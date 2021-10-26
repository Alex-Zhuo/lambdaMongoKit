package com.example.mongotest.exception;

/**
 * @author alex
 * @date 2021-10-25 15:26
 */
public class IMongoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public IMongoException(String message) {
        super(message);
    }

    public IMongoException(Throwable throwable) {
        super(throwable);
    }

    public IMongoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}