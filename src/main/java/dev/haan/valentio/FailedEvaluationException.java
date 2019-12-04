package dev.haan.valentio;

import static java.util.Objects.requireNonNull;

import java.util.SortedMap;
import java.util.stream.Collectors;

public class FailedEvaluationException extends ValidationException {

    private final SortedMap<Integer, ValidationException> exceptions;

    FailedEvaluationException(SortedMap<Integer, ValidationException> exceptions) {
        super("Failed validations:\n {0}", formatExceptions(exceptions));
        this.exceptions = requireNonNull(exceptions);
    }

    private static String formatExceptions(SortedMap<Integer, ValidationException> exceptions) {
        return exceptions.entrySet().stream()
                .map(e -> "[" + e.getKey() + "] " + e.getValue().getMessage())
                .collect(Collectors.joining("\n"));
    }

    public SortedMap<Integer, ValidationException> getExceptions() {
        return exceptions;
    }
}
