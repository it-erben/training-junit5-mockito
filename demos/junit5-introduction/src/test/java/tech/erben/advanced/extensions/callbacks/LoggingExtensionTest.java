package tech.erben.advanced.extensions.callbacks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(FinishedCallbacksExtension.class)
class LoggingExtensionTest {

    @Test
    void testAddition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void testMultiplication() {
        assertEquals(6, 2 * 3);
    }
}
