package com.iterben.advanced.extensions.conditions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(WeekdayCondition.class)
class ConditionalTest {

    @Test
    void onlyOnWeekdays() {
        System.out.println("This test only runs on weekdays.");
    }
}
