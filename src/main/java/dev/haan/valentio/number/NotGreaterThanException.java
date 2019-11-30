package dev.haan.valentio.number;

import static java.util.Objects.requireNonNull;

public class NotGreaterThanException extends NumberValidationException {

    private final String propertyName;
    private final Number value;

    public NotGreaterThanException(String propertyName, Number value) {
        super("{0} must be greater than {1}", propertyName, value);
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
