package com.iterben.advanced.tags;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TaggingTest {

    @Test
    @Tag("smoke")
    public void smokeTest() {
        System.out.println("Smoke Test");
    }

    @Test
    @Tag("integration")
    public void integrationTest() {
        System.out.println("Integration Test");
    }

}
