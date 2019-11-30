package dev.haan.valentio.strings;

import dev.haan.valentio.Validator;

public final class StringValidator {

    private StringValidator() {
        // Prevent instantiation
    }

    public static <S extends String> Validator<S> minLength(int length) {
        return (propertyName, value) -> {
            if (value.length() < length) {
                throw new NotMinimumLengthException(propertyName, length);
            }
        };
    }
}
