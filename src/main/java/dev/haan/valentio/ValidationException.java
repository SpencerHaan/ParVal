package dev.haan.valentio;

import static java.text.MessageFormat.format;

public class ValidationException extends RuntimeException {

    public ValidationException(String message, Object... parameters) {
        super(format(message, parameters));
    }

    public ValidationException(String message, Throwable cause, Object... parameters) {
        super(format(message, parameters), cause);
    }
}
