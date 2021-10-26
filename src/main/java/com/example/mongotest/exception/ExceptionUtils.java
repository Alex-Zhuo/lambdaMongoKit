package com.example.mongotest.exception;

public final class ExceptionUtils {
    private ExceptionUtils() {
    }

    public static MongoPlusException mpe(String msg, Throwable t, Object... params) {
        return new MongoPlusException(String.format(msg, params), t);
    }

    public static MongoPlusException mpe(String msg, Object... params) {
        return new MongoPlusException(String.format(msg, params));
    }

    public static MongoPlusException mpe(Throwable t) {
        return new MongoPlusException(t);
    }
}