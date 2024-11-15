package com.iterben;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class HamcrestListMatchersTest {

    @Nested
    class ElementAssertions {

        private Integer first;
        private Integer second;

        private List<Object> list;

        @BeforeEach
        void setup() {
            first = 1;
            second = 2;

            list = Arrays.asList(first, second);
        }

        @Test
        void shouldContainTwoElements() {
            assertThat(list, hasSize(2));
        }

        @Test
        void shouldContainTwoElementsWithCustomErrorMessage() {
            assertThat(String.format("The size of the list was not %d", 2), list, hasSize(2));
        }

        @Test
        void shouldContainCorrectElementsInAnyOrder() {
            assertThat(list, containsInAnyOrder(second, first));
        }

        @Test
        void shouldContainCorrectElementsInAnyOrderWithCustomErrorMessage() {
            assertThat(String.format("The list doesn't contain the objects: %s and %s", first, second),
                    list,
                    containsInAnyOrder(second, first)
            );
        }

        @Test
        void shouldContainCorrectElementsInGivenOrder() {
            assertThat(list, contains(first, second));
        }

        @Test
        void shouldContainCorrectElementsInGivenOrderWithCustomErrorMessage() {
            assertThat(String.format("The list doesn't contain the objects: %s and %s", first, second),
                    list,
                    contains(first, second)
            );
        }

        @Test
        void shouldContainCorrectElement() {
            assertThat(list, hasItem(first));
        }

        @Test
        void shouldContainCorrectElementWithCustomErrorMessage() {
            assertThat(String.format("The list doesn't contain the expected object: %s", first),
                    list,
                    hasItem(first)
            );
        }

        @Test
        void shouldNotContainIncorrectElement() {
            assertThat(list, not(hasItem(new Object())));
        }

        @Test
        void shouldNotContainIncorrectElementWithCustomErrorMessage() {
            Object incorrect = new Object();
            assertThat(String.format("The list contains an incorrect object: %s", incorrect),
                    list,
                    not(hasItem(incorrect))
            );
        }
    }

    @Nested
    class ListComparisons {

        private final List<Integer> ACTUAL = Arrays.asList(1, 2, 3);
        private final List<Integer> EXPECTED = Arrays.asList(1, 2, 3);

        @Test
        @DisplayName("Should contain the same elements")
        void shouldContainSameElements() {
            assertThat(ACTUAL, equalTo(EXPECTED));
        }

        @Test
        @DisplayName("Should contain the same elements (with custom error message)")
        void shouldContainSameElementsWithCustomErrorMessage() {
            assertThat("The lists don't contain the same elements", ACTUAL, equalTo(EXPECTED));
        }
    }
}
