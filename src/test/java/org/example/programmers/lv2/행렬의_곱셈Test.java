package org.example.programmers.lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 행렬의_곱셈Test {

    @Test
    void test1() {
        행렬의_곱셈 행렬의_곱셈 = new 행렬의_곱셈();
        int[][] arr1 = {
                {1, 4},
                {3, 2},
                {4, 1}
        };
        int[][] arr2 = {
                {3, 3},
                {3, 3}
        };

        int[][] result = {
                {15, 15},
                {15, 15},
                {15, 15}
        };
        assertArrayEquals(result, 행렬의_곱셈.solution(arr1, arr2));
    }

    @Test
    void test2() {
        행렬의_곱셈 행렬의_곱셈 = new 행렬의_곱셈();
        int[][] arr1 = {
                {2, 3, 2},
                {4, 2, 4},
                {3, 1, 4}
        };
        int[][] arr2 = {
                {5, 4, 3},
                {2, 4, 1},
                {3, 1, 1}
        };

        int[][] result = {
                {22, 22, 11},
                {36, 28, 18},
                {29, 20, 14}
        };
        assertArrayEquals(result, 행렬의_곱셈.solution(arr1, arr2));
    }
}