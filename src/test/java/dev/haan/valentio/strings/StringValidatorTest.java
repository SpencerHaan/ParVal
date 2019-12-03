package dev.haan.valentio.strings;

import static dev.haan.valentio.Validate.required;
import static dev.haan.valentio.strings.StringValidator.lengthBetween;
import static dev.haan.valentio.strings.StringValidator.maxLength;
import static dev.haan.valentio.strings.StringValidator.maxSize;
import static dev.haan.valentio.strings.StringValidator.minLength;
import static dev.haan.valentio.strings.StringValidator.notBlank;
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

    @Test
    void lengthBetween_inside() {
        assertDoesNotThrow(() -> required(TEST_STRING, lengthBetween(3,5)));
    }

    @Test
    void lengthBetween_equal_lower() {
        assertDoesNotThrow(() -> required(TEST_STRING, lengthBetween(4,5)));
    }

    @Test
    void lengthBetween_equal_upper() {
        assertDoesNotThrow(() -> required(TEST_STRING, lengthBetween(3,4)));
    }

    @Test
    void lengthBetween_outside_lower() {
        assertThrows(NotMinimumLengthException.class, () -> required(TEST_STRING, lengthBetween(5,6)));
    }

    @Test
    void lengthBetween_outside_upper() {
        assertThrows(NotMaximumLengthException.class, () -> required(TEST_STRING, lengthBetween(2,3)));
    }

    @Test
    void maxSize_under() {
        assertDoesNotThrow(() -> required(TEST_STRING, maxSize(5)));
    }

    @Test
    void maxSize_equal() {
        assertDoesNotThrow(() -> required(TEST_STRING, maxSize(4)));
    }

    @Test
    void maxSize_over() {
        assertThrows(NotMaximumSizeException.class, () -> required(TEST_STRING, maxSize(3)));
    }

    @Test
    void notBlank_hasCharacters() {
        assertDoesNotThrow(() -> required(TEST_STRING, notBlank()));
    }

    @Test
    void notBlank_justWhitespace() {
        assertThrows(NotBlankException.class, () -> required("   ", notBlank()));
    }

    @Test
    void notBlank_empty() {
        assertThrows(NotBlankException.class, () -> required("", notBlank()));
    }
}