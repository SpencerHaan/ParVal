package dev.haan.valentio;

import static java.util.Objects.requireNonNull;

public class ValueRequiredException extends ValidationException {

    private final String propertyName;

    public ValueRequiredException(String propertyName) {
        super("{0} is required; it cannot be null", propertyName);
        this.propertyName = requireNonNull(propertyName);
    }

    public String getPropertyName() {
        return propertyName;
    }
}
