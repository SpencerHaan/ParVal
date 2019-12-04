package dev.haan.valentio;

import static dev.haan.valentio.Validate.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ValidateTest {

    @Test
    void evaluate_allValid() {
        assertDoesNotThrow(() ->
                evaluate(
                        () -> require(new Object()),
                        () -> require(new Object()),
                        () -> require(new Object())
                )
        );
    }

    @Test
    void evaluate_oneInvalid() {
        try {
            evaluate(
                    () -> require(new Object()),
                    () -> require(null),
                    () -> require(new Object())
            );
        } catch (FailedEvaluationException e) {
            assertTrue(e.getMessage().contains("[1] parameter is required; it cannot be null"));
        }
    }

    @Test
    void evaluate_twoInvalid() {
        try {
            evaluate(
                    () -> require(null),
                    () -> require(new Object()),
                    () -> require(null)
            );
        } catch (FailedEvaluationException e) {
            assertTrue(e.getMessage().contains("[0] parameter is required; it cannot be null"));
            assertTrue(e.getMessage().contains("[2] parameter is required; it cannot be null"));
        }
    }

    @Test
    void required_null() {
        assertThrows(ValueRequiredException.class, () -> require(null));
    }

    @Test
    void required_returnValue() {
        Long expected = 1L;
        Long actual = require(expected);
        assertEquals(expected, actual);
    }

    @Test
    void required_multiple_noneNull() {
        assertDoesNotThrow(() -> require(new Object(), new Object(), new Object()));
    }

    @Test
    void required_multiple_oneNull() {
        try {
            require(new Object(), null, new Object());
        } catch (FailedEvaluationException e) {
            assertTrue(e.getMessage().contains("[1] parameter is required; it cannot be null"));
        }
    }

    @Test
    void required_multiple_twoNull() {
        try {
            require(null, new Object(), null);
        } catch (FailedEvaluationException e) {
            assertTrue(e.getMessage().contains("[0] parameter is required; it cannot be null"));
            assertTrue(e.getMessage().contains("[2] parameter is required; it cannot be null"));
        }
    }

    @Test
    void optional_null() {
        assertNull(optional(null, (p, v) -> { throw new ValidationException("Should not be called"); }));
    }

    @Test
    void optional_returnValue() {
        Long expected = 1L;
        Long actual = optional(expected, (p, v) -> {});
        assertEquals(expected, actual);
    }
}