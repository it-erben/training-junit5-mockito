package tech.erben.advanced.extensions.parameters;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(RandomNumberResolver.class)
class RandomNumberTest {

    @Test
    void testRandomNumber(@RandomNumber int randomNumber) {
        System.out.println("Random Number: " + randomNumber);
        assertTrue(randomNumber >= 0 && randomNumber < 100);
    }
}
