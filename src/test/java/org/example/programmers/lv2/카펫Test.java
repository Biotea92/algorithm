package org.example.programmers.lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 카펫Test {

    @Test
    void test1() {
        // given
        int brown = 10;
        int yellow = 2;

        // when
        카펫 obj = new 카펫();
        int[] result = obj.solution(brown, yellow);

        // then
        assertArrayEquals(new int[]{4, 3}, result);
    }

    @Test
    void test2() {
        // given
        int brown = 8;
        int yellow = 1;

        // when
        카펫 obj = new 카펫();
        int[] result = obj.solution(brown, yellow);

        // then
        assertArrayEquals(new int[]{3, 3}, result);
    }

    @Test
    void test3() {
        // given
        int brown = 24;
        int yellow = 24;

        // when
        카펫 obj = new 카펫();
        int[] result = obj.solution(brown, yellow);

        // then
        assertArrayEquals(new int[]{8, 6}, result);
    }
}