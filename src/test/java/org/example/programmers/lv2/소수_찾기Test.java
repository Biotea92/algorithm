package org.example.programmers.lv2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 소수_찾기Test {

    @Test
    void test() {
        // given
        String numbers = "17";
        int expected = 3;

        // when
        int solution = new 소수_찾기().solution(numbers);

        // then
        assertEquals(expected, solution);
    }

    @DisplayName("")
    @Test
    void test1() {
        // given
        String numbers = "011";
        int expected = 2;

        // when
        int solution = new 소수_찾기().solution(numbers);

        // then
        assertEquals(expected, solution);
    }
}