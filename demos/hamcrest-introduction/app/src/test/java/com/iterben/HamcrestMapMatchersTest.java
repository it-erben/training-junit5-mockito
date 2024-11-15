package com.iterben;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class HamcrestMapMatchersTest {

    private static final String INCORRECT_KEY = "incorrectKey";
    private static final String KEY = "key";
    private static final String VALUE = "value";

    private Map<String, String> map;

    @BeforeEach
    void createAndInitializeMap() {
        map = new HashMap<>();
        map.put(KEY, VALUE);
    }

    @Test
    void shouldContainCorrectKey() {
        assertThat(map, hasKey(KEY));
    }

    @Test
    void shouldContainCorrectKeyWithCustomErrorMessage() {
        assertThat(String.format("The map doesn't contain the key: %s", KEY), map, hasKey(KEY));
    }

    @Test
    void shouldNotContainIncorrectKey() {
        assertThat(map, not(hasKey(INCORRECT_KEY)));
    }

    @Test
    void shouldNotContainIncorrectKeyWithCustomErrorMessage() {
        assertThat(String.format("The map contains the key: %s", INCORRECT_KEY), map, not(hasKey(INCORRECT_KEY)));
    }

    @Test
    void shouldContainCorrectValue() {
        assertThat(map, hasEntry(KEY, VALUE));
    }

    @Test
    void shouldReturnFoundValue() {
        final String returned = map.get(KEY);
        assertThat(returned, is(VALUE));
    }

    @Test
    void shouldReturnFoundValueWithCustomErrorMessage() {
        final String returned = map.get(KEY);
        assertThat("The map returned an incorrect value", returned, is(VALUE));
    }

    @Test
    void shouldReturnNull() {
        final String returned = map.get(INCORRECT_KEY);
        assertThat(returned, nullValue());
    }

    @Test
    void shouldReturnNullWithCustomErrorMessage() {
        final String returned = map.get(INCORRECT_KEY);
        assertThat("The map didn't return null", returned, nullValue());
    }
}
