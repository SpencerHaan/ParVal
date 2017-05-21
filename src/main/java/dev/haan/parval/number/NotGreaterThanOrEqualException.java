package dev.haan.parval.number;

import static java.util.Objects.requireNonNull;

public class NotGreaterThanOrEqualException extends NumberValidationException {

    private final String propertyName;
    private final Number value;

    public NotGreaterThanOrEqualException(String propertyName, Number value) {
        super("{0} must be greater than or equal to {1}", propertyName, value);
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