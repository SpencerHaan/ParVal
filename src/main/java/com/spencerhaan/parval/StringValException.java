package com.spencerhaan.parval;

public class StringValException extends ParValException {

    public StringValException(String message, Object... parameters) {
        super(message, parameters);
    }
}
