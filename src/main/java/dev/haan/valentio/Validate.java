package dev.haan.valentio;

import static java.util.Objects.requireNonNull;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Stream;

public final class Validate {

    private static final String GENERIC_PARAMETER_NAME = "parameter";

    private Validate() {
        // Prevent instantiation
    }

    public static void evaluate(Evaluator...evaluators) {
        requireNonNull(evaluators);

        SortedMap<Integer, ValidationException> exceptions = new TreeMap<>();
        for (int i = 0; i < evaluators.length; i++) {
            try {
                evaluators[i].evaluate();
            } catch (ValidationException e) {
                exceptions.put(i, e);
            }
        }

        if (exceptions.size() > 0) {
            throw new FailedEvaluationException(exceptions);
        }
    }

    @SafeVarargs
    public static <V> V require(V value, Validator<V>...validators) {
        requireNonNull(validators);

        if (value == null) {
            throw new ValueRequiredException(GENERIC_PARAMETER_NAME);
        }
        Stream.of(validators).forEach(v -> v.validate(GENERIC_PARAMETER_NAME, value));
        return value;
    }

    public static void require(Object value, Object...values) {
        requireNonNull(values);

        Evaluator[] evaluators = Stream.concat(Stream.of(value), Stream.of(values))
                .map(o -> (Evaluator) () -> require(o))
                .toArray(Evaluator[]::new);
        evaluate(evaluators);
    }

    @SafeVarargs
    public static <V> V optional(V value, Validator<V> validator, Validator<V>...validators) {
        requireNonNull(validator);
        requireNonNull(validators);

        if (value != null) {
            Stream.concat(Stream.of(validator), Stream.of(validators))
                    .forEach(v -> v.validate(GENERIC_PARAMETER_NAME, value));
        }
        return value;
    }
}
