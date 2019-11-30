package dev.haan.valentio.numbers;

import static java.util.Objects.requireNonNull;

public class NotLessThanException extends NumberValidationException {

    private final String propertyName;
    private final Number value;

    public NotLessThanException(String propertyName, Number value) {
        super("{0} must be less than {1}", propertyName, value);
        this.propertyName = requireNonNull(propertyName);
        this.value = requireNonNull(value);
    }

    public String getPropertyName() {
        return propertyName;
    }

    public Number getValue() {
        return value;
    }
}
