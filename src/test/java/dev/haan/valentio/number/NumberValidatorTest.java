package dev.haan.valentio.number;

import static dev.haan.valentio.Validate.required;
import static dev.haan.valentio.number.NumberValidator.gt;
import static dev.haan.valentio.number.NumberValidator.gte;
import static dev.haan.valentio.number.NumberValidator.lt;
import static dev.haan.valentio.number.NumberValidator.lte;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class NumberValidatorTest {

    private static final Long TARGET = 2L;
    private static final Long UNDER = 1L;
    private static final Long EQUAL = TARGET;
    private static final Long OVER = 3L;

    @Test
    void required_number_expectLessThan_under() {
        assertDoesNotThrow(() -> required(UNDER, lt(TARGET)));
    }

    @Test
    void required_number_expectLessThan_equals() {
        assertThrows(NotLessThanException.class, () -> required(EQUAL, lt(TARGET)));
    }

    @Test
    void required_number_expectLessThan_over() {
        assertThrows(NotLessThanException.class, () -> required(OVER, lt(TARGET)));
    }

    @Test
    void required_number_expectLessThanOrEquals_under() {
        assertDoesNotThrow(() -> required(UNDER, lte(TARGET)));
    }

    @Test
    void required_number_expectLessThanOrEquals_equals() {
        assertDoesNotThrow(() -> required(EQUAL, lte(TARGET)));
    }

    @Test
    void required_number_expectLessThanOrEquals_over() {
        assertThrows(NotLessThanOrEqualException.class, () -> required(OVER, lte(TARGET)));
    }

    @Test
    void required_number_expectGreaterThan_under() {
        assertThrows(NotGreaterThanException.class, () -> required(UNDER, gt(TARGET)));
    }

    @Test
    void required_number_expectGreaterThan_equals() {
        assertThrows(NotGreaterThanException.class, () -> required(EQUAL, gt(TARGET)));
    }

    @Test
    void required_number_expectGreaterThan_over() {
        assertDoesNotThrow(() -> required(OVER, gt(TARGET)));
    }

    @Test
    void required_number_expectGreaterThanOrEquals_under() {
        assertThrows(NotGreaterThanOrEqualException.class, () -> required(UNDER, gte(TARGET)));
    }

    @Test
    void required_number_expectGreaterThanOrEquals_equals() {
    assertDoesNotThrow(() -> required(EQUAL, gte(TARGET)));
    }

    @Test
    void required_number_expectGreaterThanOrEquals_over() {
        assertDoesNotThrow(() -> required(OVER, gte(TARGET)));
    }
}