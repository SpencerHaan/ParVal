package dev.haan.parval;

import static java.text.MessageFormat.format;

public class ParValException extends IllegalArgumentException {

    public ParValException(String message, Object... parameters) {
        super(format(message, parameters));
    }

    public ParValException(String message, Throwable cause, Object... parameters) {
        super(format(message, parameters), cause);
    }
}
