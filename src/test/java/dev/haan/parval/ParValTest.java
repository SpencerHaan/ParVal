package dev.haan.parval;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParValTest {

    @Test
    void required_null() {
        assertThrows(ValueRequiredException.class, () -> ParVal.required(null));
    }
}