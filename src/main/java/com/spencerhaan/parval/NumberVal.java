package com.spencerhaan.parval;

import static java.util.Objects.requireNonNull;

import java.util.function.Consumer;

public class NumberVal {

    public static <N extends Number & Comparable<N>> Consumer<N> lt(N maximum) {
        requireNonNull(maximum);
        return n -> {
            if (n.compareTo(maximum) >= 0) {
                throw new NumberValException("Numeric parameter must be less than `{0}`", maximum);
            }
        };
    }

    public static <N extends Number & Comparable<N>> Consumer<N> lte(N maximum) {
        requireNonNull(maximum);
        return n -> {
            if (n.compareTo(maximum) > 0) {
                throw new NumberValException("Numeric parameter must be less than or equal to `{0}`", maximum);
            }
        };
    }

    public static <N extends Number & Comparable<N>> Consumer<N> gt(N minimum) {
        requireNonNull(minimum);
        return n -> {
            if (n.compareTo(minimum) <= 0) {
                throw new NumberValException("Numeric parameter must be greater than `{0}`", minimum);
            }
        };
    }

    public static <N extends Number & Comparable<N>> Consumer<N> gte(N minimum) {
        requireNonNull(minimum);
        return n -> {
            if (n.compareTo(minimum) < 0) {
                throw new NumberValException("Numeric parameter must be greater than or equal to `{0}`", minimum);
            }
        };
    }

    public static <N extends Number & Comparable<N>> Consumer<N> range(N minimum, N maximum) {
        requireNonNull(minimum);
        requireNonNull(maximum);
        if (minimum.compareTo(maximum) > 0) {
            throw new IllegalArgumentException("Minimum must be less than maximum");
        }
        return n -> {
            if (n.compareTo(minimum) < 0 || n.compareTo(maximum) > 0) {
                throw new NumberValException("Parameter must be greater than or equal to `{0}` and less than or equal to `{1}`", minimum, maximum);
            }
        };
    }
}
