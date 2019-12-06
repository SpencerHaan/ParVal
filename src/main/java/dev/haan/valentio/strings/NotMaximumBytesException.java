package dev.haan.valentio.strings;

public class NotMaximumBytesException extends StringValidationException {

    public NotMaximumBytesException(String propertyName, int size) {
        super("{0} exceeds maximum bytes {1}", propertyName, size);
    }
}
