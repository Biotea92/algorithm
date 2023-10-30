package org.example.programmers.lv1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 모의고사Test {

    @Test
    void test1() {
        int[] answers = {1, 2, 3, 4, 5};
        int[] expected = {1};
        int[] actual = new 모의고사().solution(answers);
        assertArrayEquals(expected, actual);
    }

    @Test
    void test2() {
        int[] answers = {1, 3, 2, 4, 2};
        int[] expected = {1, 2, 3};
        int[] actual = new 모의고사().solution(answers);
        assertArrayEquals(expected, actual);
    }
}