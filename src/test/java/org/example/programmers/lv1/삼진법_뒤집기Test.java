package org.example.programmers.lv1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 삼진법_뒤집기Test {

    @Test
    void test1() {
        // given
        int n = 45;
        int expected = 7;

        // when
        int actual = new 삼진법_뒤집기().solution(n);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        // given
        int n = 125;
        int expected = 229;

        // when
        int actual = new 삼진법_뒤집기().solution(n);

        // then
        assertEquals(expected, actual);
    }
}