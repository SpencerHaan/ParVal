package dev.haan.valentio.strings;

import dev.haan.valentio.ValidationException;

public class StringValidationException extends ValidationException {

    public StringValidationException(String message, Object... parameters) {
        super(message, parameters);
    }
}
