package dev.haan.valentio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidateTest {

    @Test
    void required_null() {
        assertThrows(ValueRequiredException.class, () -> Validate.required(null));
    }
}