package dev.haan.valentio.numbers;

import static java.util.Objects.requireNonNull;

public class NotAtMostException extends NumberValidationException {

    private final String propertyName;
    private final Number value;

    public NotAtMostException(String propertyName, Number value) {
        super("{0} must be at most {1}", propertyName, value);
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
