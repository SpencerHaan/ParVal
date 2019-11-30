package dev.haan.valentio;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
}