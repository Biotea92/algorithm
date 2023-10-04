package org.example.programmers.lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 이진_변환_반복하기Test {

    @Test
    void test1() {
        // given
        String s = "110010101001";
        int[] expected = {3, 8};

        // when
        int[] actual = new 이진_변환_반복하기().solution(s);

        // then
        assertArrayEquals(expected, actual);
    }

    @Test
    void test2() {
        // given
        String s = "01110";
        int[] expected = {3, 3};

        // when
        int[] actual = new 이진_변환_반복하기().solution(s);

        // then
        assertArrayEquals(expected, actual);
    }

    @Test
    void test3() {
        // given
        String s = "1111111";
        int[] expected = {4, 1};

        // when
        int[] actual = new 이진_변환_반복하기().solution(s);

        // then
        assertArrayEquals(expected, actual);
    }
}