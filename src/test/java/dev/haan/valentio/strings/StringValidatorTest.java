package dev.haan.valentio.strings;

import static dev.haan.valentio.Validate.*;
import static dev.haan.valentio.strings.StringValidator.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dev.haan.valentio.Validate;

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
}