package dev.haan.valentio.collections;

import java.util.Collection;

import dev.haan.valentio.Validator;

public final class CollectionValidator {

    private CollectionValidator() {
        // Prevent instantiation
    }

    public static <C extends Collection<?>>Validator<C> notEmpty() {
        return (propertyName, value) -> {
            if (value.isEmpty()) {
                throw new NotEmptyException(propertyName);
            }
        };
    }
}
