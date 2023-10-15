package org.example.backjun;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RGB거리Test {

    @Test
    void test1() {
        int[][] arr = {
                {26, 40, 83}, // 26
                {49, 60, 57}, // 57
                {13, 89, 99}  // 13
        };
        int expected = 96;
        int actual = new RGB거리().solution(arr);
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int[][] arr = {
                {1, 100, 100},
                {100, 1, 100},
                {100, 100, 1}
        };
        int expected = 3;
        int actual = new RGB거리().solution(arr);
        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        int[][] arr = {
                {1, 100, 100},
                {100, 100, 100},
                {1, 100, 100}
        };
        int expected = 102;
        int actual = new RGB거리().solution(arr);
        assertEquals(expected, actual);
    }

    @Test
    void test4() {
        int[][] arr = {
                {30, 19, 5},
                {64, 77, 64},
                {15, 19, 97},
                {4, 71, 57},
                {90, 86, 84},
                {93, 32, 91}
        };
        int expected = 208;
        int actual = new RGB거리().solution(arr);
        assertEquals(expected, actual);
    }

    @Test
    void test5() {
        int[][] arr = {
                {71, 39, 44},
                {32, 83, 55},
                {51, 37, 63},
                {89, 29, 100},
                {83, 58, 11},
                {65, 13, 15},
                {47, 25, 29},
                {60, 66, 19}
        };
        int expected = 253;
        int actual = new RGB거리().solution(arr);
        assertEquals(expected, actual);
    }
}