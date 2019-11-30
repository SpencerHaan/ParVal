package dev.haan.valentio.number;

import static java.util.Objects.requireNonNull;

import dev.haan.valentio.Validator;

public final class NumberValidator {

    private NumberValidator() {
        // Prevent instantiation
    }

    public static <N extends Number & Comparable<N>> Validator<N> lt(N number) {
        requireNonNull(number);
        return (propertyName, value) -> {
            if (value.compareTo(number) >= 0) {
                throw new NotLessThanException(propertyName, value);
            }
        };
    }

    public static <N extends Number & Comparable<N>> Validator<N> lte(N number) {
        requireNonNull(number);
        return (propertyName, value) -> {
            if (value.compareTo(number) > 0) {
                throw new NotLessThanOrEqualException(propertyName, value);
            }
        };
    }

    public static <N extends Number & Comparable<N>> Validator<N> gt(N number) {
        requireNonNull(number);
        return (propertyName, value) -> {
            if (value.compareTo(number) <= 0) {
                throw new NotGreaterThanException(propertyName, value);
            }
        };
    }

    public static <N extends Number & Comparable<N>> Validator<N> gte(N number) {
        requireNonNull(number);
        return (propertyName, value) -> {
            if (value.compareTo(number) < 0) {
                throw new NotGreaterThanOrEqualException(propertyName, value);
            }
        };
    }

    public static <N extends Number & Comparable<N>> Validator<N> range(N lower, N upper) {
        return gte(lower).andThen(lt(upper));
    }
}
