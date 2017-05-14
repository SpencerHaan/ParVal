package com.spencerhaan.parval;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class ParVal {

    @SafeVarargs
    public static <T> T required(T value, Consumer<T>... validators) {
        if (value == null) {
            throw new RequiredValException();
        }
        Stream.of(validators)
                .reduce(Consumer::andThen)
                .ifPresent(c -> c.accept(value));
        return value;
    }

    @SafeVarargs
    public static <T> T optional(T value, Consumer<T>... validators) {
        if (value != null) {
            Stream.of(validators)
                    .reduce(Consumer::andThen)
                    .ifPresent(c -> c.accept(value));
        }
        return value;
    }
}
