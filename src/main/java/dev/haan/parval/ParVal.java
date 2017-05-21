package dev.haan.parval;

import java.util.stream.Stream;

public final class ParVal {

    private static final String GENERIC_PARAMETER_NAME = "parameter";

    private ParVal() {
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
}
