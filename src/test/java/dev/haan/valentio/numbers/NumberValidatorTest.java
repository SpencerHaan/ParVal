package dev.haan.valentio.numbers;

import static dev.haan.valentio.Validate.require;
import static dev.haan.valentio.numbers.NumberValidator.gt;
import static dev.haan.valentio.numbers.NumberValidator.gte;
import static dev.haan.valentio.numbers.NumberValidator.lt;
import static dev.haan.valentio.numbers.NumberValidator.lte;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import dev.haan.valentio.Validate;

class NumberValidatorTest {

    private static final Long TARGET = 2L;
    private static final Long UNDER = 1L;
    private static final Long EQUAL = TARGET;
    private static final Long OVER = 3L;

    @Test
    void required_number_expectLessThan_under() {
        assertDoesNotThrow(() -> Validate.require(UNDER, lt(TARGET)));
    }

    @Test
    void required_number_expectLessThan_equals() {
        assertThrows(NotLessThanException.class, () -> Validate.require(EQUAL, lt(TARGET)));
    }

    @Test
    void required_number_expectLessThan_over() {
        assertThrows(NotLessThanException.class, () -> Validate.require(OVER, lt(TARGET)));
    }

    @Test
    void required_number_expectLessThanOrEquals_under() {
        assertDoesNotThrow(() -> Validate.require(UNDER, lte(TARGET)));
    }

    @Test
    void required_number_expectLessThanOrEquals_equals() {
        assertDoesNotThrow(() -> Validate.require(EQUAL, lte(TARGET)));
    }

    @Test
    void required_number_expectLessThanOrEquals_over() {
        assertThrows(NotLessThanOrEqualException.class, () -> Validate.require(OVER, lte(TARGET)));
    }

    @Test
    void required_number_expectGreaterThan_under() {
        assertThrows(NotGreaterThanException.class, () -> Validate.require(UNDER, gt(TARGET)));
    }

    @Test
    void required_number_expectGreaterThan_equals() {
        assertThrows(NotGreaterThanException.class, () -> Validate.require(EQUAL, gt(TARGET)));
    }

    @Test
    void required_number_expectGreaterThan_over() {
        assertDoesNotThrow(() -> Validate.require(OVER, gt(TARGET)));
    }

    @Test
    void required_number_expectGreaterThanOrEquals_under() {
        assertThrows(NotGreaterThanOrEqualException.class, () -> Validate.require(UNDER, gte(TARGET)));
    }

    @Test
    void required_number_expectGreaterThanOrEquals_equals() {
    assertDoesNotThrow(() -> Validate.require(EQUAL, gte(TARGET)));
    }

    @Test
    void required_number_expectGreaterThanOrEquals_over() {
        assertDoesNotThrow(() -> Validate.require(OVER, gte(TARGET)));
    }
}