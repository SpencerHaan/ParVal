package dev.haan.valentio.collections;

import static dev.haan.valentio.Validate.required;
import static dev.haan.valentio.collections.CollectionValidator.notEmpty;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class CollectionValidatorTest {

    @Test
    void notEmpty_assignResponse() {
        Collection<Long> expected = Collections.singleton(1L);
        Collection<Long> actual = required(expected, notEmpty());
        assertEquals(expected, actual);
    }

    @Test
    void notEmpty_singleItem() {
        assertDoesNotThrow(() -> required(Collections.singleton(1L), notEmpty()));
    }

    @Test
    void notEmpty_multipleItems() {
        assertDoesNotThrow(() -> required(Arrays.asList(1L, 2L), notEmpty()));
    }

    @Test
    void notEmpty_empty() {
        assertThrows(NotEmptyException.class, () -> required(Collections.emptyList(), notEmpty()));
    }
}