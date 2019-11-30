package dev.haan.valentio;

import static java.util.Objects.requireNonNull;

/**
 * Functional interface for validating parameters.
 */
@FunctionalInterface
public interface Validator<V> {

    void validate(String propertyName, V value);

    default Validator<V> andThen(Validator<? super V> after) {
        requireNonNull(after);
        return (propertyName, value) -> {
            validate(propertyName, value);
            after.validate(propertyName, value);
        };
    }
}