package dev.haan.valentio.strings;

import static java.util.Objects.requireNonNull;

public class NotMinimumLengthException extends StringValidationException {

    private final String propertyName;
    private final int length;

    public NotMinimumLengthException(String propertyName, int length) {
        super("{0} is less than {1}", propertyName, length);
        this.propertyName = requireNonNull(propertyName);
        this.length = length;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public int getLength() {
        return length;
    }
}
