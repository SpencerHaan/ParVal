package com.spencerhaan.parval;

import java.util.function.Consumer;

public class StringVal {

    public static <S extends String> Consumer<S> minLength(int length) {
        return string -> {
            if (string.length() < length) {
                throw new StringValException("String parameter length must be less than or equal to `{0}`", length);
            }
        };
    }

    public static <S extends String> Consumer<S> maxLength(int length) {
        return string -> {
            if (string.length() > length) {
                throw new StringValException("String parameter length must be less than or equal to `{0}`", length);
            }
        };
    }

    public static <S extends String> Consumer<S> lengthBetween(int minimum, int maximum) {
        if (minimum > maximum) {
            throw new IllegalArgumentException("Minimum must be less than maximum");
        }
        return string -> {
            if (string.length() < minimum || string.length() > maximum) {
                throw new StringValException("String parameter must be greater than or equal to `{0}` and less than or equal to `{1}`", minimum, maximum);
            }
        };
    }

    public static <S extends String> Consumer<S> notBlank() {
        return string -> {
            if (string.isEmpty()) {
                throw new StringValException("String parameter must not be empty");
            }
        };
    }

    public static <S extends String> Consumer<S> notWhitespace() {
        return string -> {
            if (string.trim().isEmpty()) {
                throw new StringValException("String parameter must not be empty or contain only whitespace");
            }
        };
    }
}
