package dev.haan.valentio.strings;

import static dev.haan.valentio.Validate.required;
import static dev.haan.valentio.strings.StringValidator.maxLength;
import static dev.haan.valentio.strings.StringValidator.minLength;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class StringValidatorTest {

    private static final String TEST_STRING = "Test";

    @Test
    void minLength_under() {
        assertThrows(NotMinimumLengthException.class, () -> required(TEST_STRING, minLength(5)));
    }

    @Test
    void minLength_equal() {
        assertDoesNotThrow(() -> required(TEST_STRING, minLength(4)));
    }

    @Test
    void minLength_over() {
        assertDoesNotThrow(() -> required(TEST_STRING, minLength(3)));
    }

    @Test
    void maxLength_under() {
        assertDoesNotThrow(() -> required(TEST_STRING, maxLength(4)));
    }

    @Test
    void maxLength_equal() {
        assertDoesNotThrow(() -> required(TEST_STRING, maxLength(4)));
    }

    @Test
    void maxLength_over() {
        assertThrows(NotMaximumLengthException.class, () -> required(TEST_STRING, maxLength(3)));
    }
}