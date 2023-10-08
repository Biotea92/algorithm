package org.example.programmers.lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 쿼드압축_후_개수_세기Test {

    @Test
    void test1() {
        쿼드압축_후_개수_세기 obj = new 쿼드압축_후_개수_세기();
        int[][] arr = {
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 1}
        };
        int[] expected = {4, 9};
        int[] actual = obj.solution(arr);
        assertArrayEquals(expected, actual);
    }

    @Test
    void test2() {
        쿼드압축_후_개수_세기 obj = new 쿼드압축_후_개수_세기();
        int[][] arr = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 1, 1}
        };
        int[] expected = {10, 15};
        int[] actual = obj.solution(arr);
        assertArrayEquals(expected, actual);
    }

    @Test
    void test3() {
        쿼드압축_후_개수_세기 obj = new 쿼드압축_후_개수_세기();
        int[][] arr = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        int[] expected = {0, 1};
        int[] actual = obj.solution(arr);
        assertArrayEquals(expected, actual);
    }
}