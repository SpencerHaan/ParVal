package dev.haan.valentio.strings;

import java.nio.charset.Charset;

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

    public static <S extends String> Validator<S> maxLength(int length) {
        return (propertyName, value) -> {
            if (value.length() > length) {
                throw new NotMaximumLengthException(propertyName, length);
            }
        };
    }

    public static <S extends String> Validator<S> lengthBetween(int lower, int upper) {
        Validator<S> minLength = minLength(lower);
        Validator<S> maxLength = maxLength(upper);
        return minLength.andThen(maxLength);
    }

    public static <S extends String> Validator<S> maxSize(int size) {
        return maxSize(size, Charset.defaultCharset());
    }

    public static <S extends String> Validator<S> maxSize(int size, Charset charset) {
        return (propertyName, value) -> {
            if (value.getBytes(charset).length > size) {
                throw new NotMaximumSizeException(propertyName, size);
            }
        };
    }

    public static <S extends String> Validator<S> notBlank() {
        return (propertyName, value) -> {
            if (value.trim().isEmpty()) {
                throw new NotBlankException(propertyName);
            }
        };
    }
}
