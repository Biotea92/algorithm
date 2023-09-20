package org.example.programmers.lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 거리두기_확인하기Test {

    @Test
    void test1() {
        거리두기_확인하기 거리두기_확인하기 = new 거리두기_확인하기();
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        int[] result = {1, 0, 1, 1, 1};
        assertArrayEquals(result, 거리두기_확인하기.solution(places));
    }
}