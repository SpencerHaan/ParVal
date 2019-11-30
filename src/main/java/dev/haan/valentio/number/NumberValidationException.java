package dev.haan.valentio.number;

import dev.haan.valentio.ValidationException;

public class NumberValidationException extends ValidationException {

    public NumberValidationException(String message, Object... parameters) {
        super(message, parameters);
    }
}
