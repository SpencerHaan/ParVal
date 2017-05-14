package com.spencerhaan.parval;

public class RequiredValException extends ParValException {

    public RequiredValException() {
        super("Parameter is required; it cannot be null");
    }
}
