package com.example.mongotest.exception;

/**
 * @author alex
 * @date 2021-10-25 15:26
 */
public class MongoPlusException  extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MongoPlusException(String message) {
        super(message);
    }

    public MongoPlusException(Throwable throwable) {
        super(throwable);
    }

    public MongoPlusException(String message, Throwable throwable) {
        super(message, throwable);
    }
}