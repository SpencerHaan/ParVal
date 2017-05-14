package com.spencerhaan.parval;

import java.text.MessageFormat;

public class ParValException extends RuntimeException {

    public ParValException(String message, Object... parameters) {
        super(MessageFormat.format(message, parameters));
    }
}
