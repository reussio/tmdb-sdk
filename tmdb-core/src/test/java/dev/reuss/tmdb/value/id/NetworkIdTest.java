package dev.reuss.tmdb.value.id;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NetworkIdTest {

    @Test
    void createsNetworkId() {
        NetworkId id = NetworkId.of(49);

        assertEquals(49, id.value());
        assertEquals("49", id.asString());
        assertEquals("49", id.toString());
    }

    @Test
    void rejectsZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> NetworkId.of(0));

        assertEquals("Network id must be greater than 0", exception.getMessage());
    }

    @Test
    void rejectsNegativeValue() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> NetworkId.of(-1));

        assertEquals("Network id must be greater than 0", exception.getMessage());
    }
}
