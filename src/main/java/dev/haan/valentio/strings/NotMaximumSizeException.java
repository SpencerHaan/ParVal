package dev.haan.valentio.strings;

public class NotMaximumSizeException extends StringValidationException {

    public NotMaximumSizeException(String propertyName, int size) {
        super("{0} exceeds maximum size {1}", propertyName, size);
    }
}
