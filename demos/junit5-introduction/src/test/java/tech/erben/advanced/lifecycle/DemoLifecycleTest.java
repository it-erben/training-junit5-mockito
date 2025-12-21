package tech.erben.advanced.lifecycle;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tests with Test Instance Lifecycle Configurations")
public class DemoLifecycleTest {

    /**
     * Lifecycle PER_METHOD: A new instance is created for each test method.
     */
    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_METHOD)
    @DisplayName("PER_METHOD Lifecycle: New instance per method")
    class PerMethodLifecycleTests {

        private int counter = 0;

        @Test
        void testCounterOne() {
            counter++;
            assertEquals(1, counter, "Counter should be 1 in each test instance");
        }

        @Test
        void testCounterTwo() {
            counter++;
            assertEquals(1, counter, "Counter should be 1 in each test instance");
        }
    }

    /**
     * Lifecycle PER_CLASS: A single instance is shared across all test methods.
     */
    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("PER_CLASS Lifecycle: Shared instance across all methods")
    class PerClassLifecycleTests {

        private int counter = 0;

        @BeforeAll
        void setUpOnce() {
            counter = 0;
        }

        @Test
        @Order(1)
        void testCounterOne() {
            counter++;
            assertEquals(1, counter, "Counter should increase with each test run");
        }

        @Test
        @Order(2)
        void testCounterTwo() {
            counter++;
            assertEquals(2, counter, "Counter should reflect the cumulative test count");
        }

        @Test
        @Order(3)
        void testCounterThree() {
            counter++;
            assertEquals(3, counter, "Counter should reflect the cumulative test count");
        }
    }
}
