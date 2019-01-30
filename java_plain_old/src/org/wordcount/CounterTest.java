package org.wordcount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CounterTest {
    @Test
    public void a_single_word_has_a_count_of_1() {
        assertEquals(1, new Counter().countOccurrences("word").get("word"));
        assertEquals(1, new Counter().countOccurrences("anotherword").get("anotherword"));
    }

    @Test
    public void empty_strings_are_ignored() {
        assertFalse(new Counter().countOccurrences("word  word").containsKey(""));
    }

    @Test
    public void two_different_words_are_counted_separately() {
        assertEquals(1, new Counter().countOccurrences("word anotherword").get("word"));
        assertEquals(1, new Counter().countOccurrences("word anotherword").get("anotherword"));
    }

    @Test
    public void count_words_that_appear_multiple_times() {
        assertEquals(2, new Counter().countOccurrences("word word").get("word"));
    }
}
