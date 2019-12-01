package dev.haan.valentio.collections;

import dev.haan.valentio.ValidationException;

public class NotEmptyException extends ValidationException {

    public NotEmptyException(String propertyName) {
        super("{0} must not be empty", propertyName);
    }
}
