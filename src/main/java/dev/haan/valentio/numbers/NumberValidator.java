package dev.haan.valentio.numbers;

import static java.util.Objects.requireNonNull;

import dev.haan.valentio.Validator;

public final class NumberValidator {

    private NumberValidator() {
        // Prevent instantiation
    }

    public static <N extends Number & Comparable<N>> Validator<N> under(N number) {
        requireNonNull(number);
        return (propertyName, value) -> {
            if (value.compareTo(number) >= 0) {
                throw new NotUnderException(propertyName, value);
            }
        };
    }

    public static <N extends Number & Comparable<N>> Validator<N> atLeast(N number) {
        requireNonNull(number);
        return (propertyName, value) -> {
            if (value.compareTo(number) > 0) {
                throw new NotAtLeastException(propertyName, value);
            }
        };
    }

    public static <N extends Number & Comparable<N>> Validator<N> over(N number) {
        requireNonNull(number);
        return (propertyName, value) -> {
            if (value.compareTo(number) <= 0) {
                throw new NotOverException(propertyName, value);
            }
        };
    }

    public static <N extends Number & Comparable<N>> Validator<N> atMost(N number) {
        requireNonNull(number);
        return (propertyName, value) -> {
            if (value.compareTo(number) < 0) {
                throw new NotAtMostException(propertyName, value);
            }
        };
    }

    public static <N extends Number & Comparable<N>> Validator<N> range(N lower, N upper) {
        return atMost(lower).andThen(under(upper));
    }
}
