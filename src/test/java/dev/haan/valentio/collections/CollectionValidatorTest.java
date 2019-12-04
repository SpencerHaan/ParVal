package dev.haan.valentio.collections;

import static dev.haan.valentio.Validate.require;
import static dev.haan.valentio.collections.CollectionValidator.notEmpty;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import dev.haan.valentio.Validate;

class CollectionValidatorTest {

    @Test
    void notEmpty_assignResponse() {
        Collection<Long> expected = Collections.singleton(1L);
        Collection<Long> actual = Validate.require(expected, notEmpty());
        assertEquals(expected, actual);
    }

    @Test
    void notEmpty_singleItem() {
        assertDoesNotThrow(() -> Validate.require(Collections.singleton(1L), notEmpty()));
    }

    @Test
    void notEmpty_multipleItems() {
        assertDoesNotThrow(() -> Validate.require(Arrays.asList(1L, 2L), notEmpty()));
    }

    @Test
    void notEmpty_empty() {
        assertThrows(NotEmptyException.class, () -> Validate.require(Collections.emptyList(), notEmpty()));
    }
}