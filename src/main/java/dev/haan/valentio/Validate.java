package dev.haan.valentio;

import java.util.stream.Stream;

public final class Validate {

    private static final String GENERIC_PARAMETER_NAME = "parameter";

    private Validate() {
        // Prevent instantiation
    }

    @SafeVarargs
    public static <V> V required(V value, Validator<V>...validators) {
        if (value == null) {
            throw new ValueRequiredException(GENERIC_PARAMETER_NAME);
        }
        Stream.of(validators).forEach(v -> v.validate(GENERIC_PARAMETER_NAME, value));
        return value;
    }

    @SafeVarargs
    public static <V> V optional(V value, Validator<V>...validators) {
        if (value != null) {
            Stream.of(validators).forEach(v -> v.validate(GENERIC_PARAMETER_NAME, value));
        }
        return value;
    }
}
