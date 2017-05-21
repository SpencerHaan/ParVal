package dev.haan.parval.number;

import dev.haan.parval.ParValException;

public class NumberValidationException extends ParValException {

    public NumberValidationException(String message, Object... parameters) {
        super(message, parameters);
    }
}
