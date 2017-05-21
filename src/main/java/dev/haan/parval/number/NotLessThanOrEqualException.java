package dev.haan.parval.number;

import static java.util.Objects.requireNonNull;

public class NotLessThanOrEqualException extends NumberValidationException {

    private final String propertyName;
    private final Number value;

    public NotLessThanOrEqualException(String propertyName, Number value) {
        super("{0} must be less than or equal to {1}", propertyName, value);
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
