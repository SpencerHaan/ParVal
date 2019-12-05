package dev.haan.valentio.numbers;

import static dev.haan.valentio.numbers.NumberValidator.atLeast;
import static dev.haan.valentio.numbers.NumberValidator.atMost;
import static dev.haan.valentio.numbers.NumberValidator.over;
import static dev.haan.valentio.numbers.NumberValidator.under;
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
    void required_number_mustBeUnder_isUnder() {
        assertDoesNotThrow(() -> Validate.require(UNDER, under(TARGET)));
    }

    @Test
    void required_number_mustBeUnder_isEqual() {
        assertThrows(NotUnderException.class, () -> Validate.require(EQUAL, under(TARGET)));
    }

    @Test
    void required_number_mustBeUnder_isOver() {
        assertThrows(NotUnderException.class, () -> Validate.require(OVER, under(TARGET)));
    }

    @Test
    void required_number_mustBeAtLeast_isUnder() {
        assertDoesNotThrow(() -> Validate.require(UNDER, atLeast(TARGET)));
    }

    @Test
    void required_number_mustBeAtLeast_isEqual() {
        assertDoesNotThrow(() -> Validate.require(EQUAL, atLeast(TARGET)));
    }

    @Test
    void required_number_mustBeAtLeast_isOver() {
        assertThrows(NotAtLeastException.class, () -> Validate.require(OVER, atLeast(TARGET)));
    }

    @Test
    void required_number_mustBeOver_isUnder() {
        assertThrows(NotOverException.class, () -> Validate.require(UNDER, over(TARGET)));
    }

    @Test
    void required_number_mustBeOver_isEqual() {
        assertThrows(NotOverException.class, () -> Validate.require(EQUAL, over(TARGET)));
    }

    @Test
    void required_number_mustBeOver_isOver() {
        assertDoesNotThrow(() -> Validate.require(OVER, over(TARGET)));
    }

    @Test
    void required_number_mustBeAtMost_isUnder() {
        assertThrows(NotAtMostException.class, () -> Validate.require(UNDER, atMost(TARGET)));
    }

    @Test
    void required_number_mustBeAtMost_isEqual() {
    assertDoesNotThrow(() -> Validate.require(EQUAL, atMost(TARGET)));
    }

    @Test
    void required_number_mustBeAtMost_isOver() {
        assertDoesNotThrow(() -> Validate.require(OVER, atMost(TARGET)));
    }
}