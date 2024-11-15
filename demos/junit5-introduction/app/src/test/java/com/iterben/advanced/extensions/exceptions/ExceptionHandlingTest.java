package com.iterben.advanced.extensions.exceptions;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(IgnoreNullPointerExceptionHandler.class)
class ExceptionHandlingTest {

    @Test
    void testNullPointerExceptionIgnored() {
        String value = null;
        System.out.println(value.length()); // wird NullPointerException auslösen, aber ignoriert
    }

    @Test
    @Disabled("will fail")
    void testArithmeticExceptionNotIgnored() {
        int result = 1 / 0; // wird ArithmeticException auslösen und nicht ignoriert
    }
}
