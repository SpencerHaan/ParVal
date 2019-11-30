package dev.haan.valentio.numbers;

import dev.haan.valentio.ValidationException;

public class NumberValidationException extends ValidationException {

    public NumberValidationException(String message, Object... parameters) {
        super(message, parameters);
    }
}
