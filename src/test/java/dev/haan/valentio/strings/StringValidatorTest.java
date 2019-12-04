package dev.haan.valentio.strings;

import static dev.haan.valentio.Validate.require;
import static dev.haan.valentio.strings.StringValidator.lengthBetween;
import static dev.haan.valentio.strings.StringValidator.maxLength;
import static dev.haan.valentio.strings.StringValidator.maxSize;
import static dev.haan.valentio.strings.StringValidator.minLength;
import static dev.haan.valentio.strings.StringValidator.notBlank;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import dev.haan.valentio.Validate;

class StringValidatorTest {

    private static final String TEST_STRING = "Test";

    @Test
    void minLength_under() {
        assertThrows(NotMinimumLengthException.class, () -> Validate.require(TEST_STRING, minLength(5)));
    }

    @Test
    void minLength_equal() {
        assertDoesNotThrow(() -> Validate.require(TEST_STRING, minLength(4)));
    }

    @Test
    void minLength_over() {
        assertDoesNotThrow(() -> Validate.require(TEST_STRING, minLength(3)));
    }

    @Test
    void maxLength_under() {
        assertDoesNotThrow(() -> Validate.require(TEST_STRING, maxLength(4)));
    }

    @Test
    void maxLength_equal() {
        assertDoesNotThrow(() -> Validate.require(TEST_STRING, maxLength(4)));
    }

    @Test
    void maxLength_over() {
        assertThrows(NotMaximumLengthException.class, () -> Validate.require(TEST_STRING, maxLength(3)));
    }

    @Test
    void lengthBetween_inside() {
        assertDoesNotThrow(() -> Validate.require(TEST_STRING, lengthBetween(3,5)));
    }

    @Test
    void lengthBetween_equal_lower() {
        assertDoesNotThrow(() -> Validate.require(TEST_STRING, lengthBetween(4,5)));
    }

    @Test
    void lengthBetween_equal_upper() {
        assertDoesNotThrow(() -> Validate.require(TEST_STRING, lengthBetween(3,4)));
    }

    @Test
    void lengthBetween_outside_lower() {
        assertThrows(NotMinimumLengthException.class, () -> Validate.require(TEST_STRING, lengthBetween(5,6)));
    }

    @Test
    void lengthBetween_outside_upper() {
        assertThrows(NotMaximumLengthException.class, () -> Validate.require(TEST_STRING, lengthBetween(2,3)));
    }

    @Test
    void maxSize_under() {
        assertDoesNotThrow(() -> Validate.require(TEST_STRING, maxSize(5)));
    }

    @Test
    void maxSize_equal() {
        assertDoesNotThrow(() -> Validate.require(TEST_STRING, maxSize(4)));
    }

    @Test
    void maxSize_over() {
        assertThrows(NotMaximumSizeException.class, () -> Validate.require(TEST_STRING, maxSize(3)));
    }

    @Test
    void notBlank_hasCharacters() {
        assertDoesNotThrow(() -> Validate.require(TEST_STRING, notBlank()));
    }

    @Test
    void notBlank_justWhitespace() {
        assertThrows(NotBlankException.class, () -> Validate.require("   ", notBlank()));
    }

    @Test
    void notBlank_empty() {
        assertThrows(NotBlankException.class, () -> Validate.require("", notBlank()));
    }
}