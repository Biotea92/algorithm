package org.example.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingCharactersTest {

    @DisplayName("")
    @Test
    void test() {
        // given
        String s = "abcabcbb";

        // when
        int result = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);

        // then // will be "abc"
        assertEquals(3, result);
    }

    @DisplayName("")
    @Test
    void test2() {
        // given
        String s = "bbbbb";

        // when
        int result = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);

        // then // will be "b"
        assertEquals(1, result);
    }

    @DisplayName("")
    @Test
    void test3() {
        // given
        String s = "pwwkew";

        // when
        int result = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);

        // then // will be "wke"
        assertEquals(3, result);
    }
}