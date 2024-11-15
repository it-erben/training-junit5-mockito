package com.iterben.advanced.extensions.context;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(TimingExtension.class)
public class TimingExtensionTest {

    @Test
    void testAddition() throws InterruptedException {
        Thread.sleep(100); // Simuliert eine kurze Pause
        assertEquals(2, 1 + 1);
    }

    @Test
    void testMultiplication() throws InterruptedException {
        Thread.sleep(200); // Simuliert eine längere Pause
        assertEquals(6, 2 * 3);
    }
}
