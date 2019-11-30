package dev.haan.valentio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ValidateTest {

    @Test
    void required_null() {
        assertThrows(ValueRequiredException.class, () -> Validate.required(null));
    }

    @Test
    void required_returnValue() {
        Long expected = 1L;
        Long actual = Validate.required(expected);
        assertEquals(expected, actual);
    }

    @Test
    void optional_null() {
        assertNull(Validate.optional(null));
    }

    @Test
    void optional_returnValue() {
        Long expected = 1L;
        Long actual = Validate.optional(expected);
        assertEquals(expected, actual);
    }
}