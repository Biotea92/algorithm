package org.example.programmers.lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 하노이의_탑Test {

    @Test
    void test1() {
        int n = 2;
        int[][] expected = {
                {1, 2},
                {1, 3},
                {2, 3}
        };
        int[][] actual = new 하노이의_탑().solution(n);
        assertArrayEquals(expected, actual);
    }

    @Test
    void test2() {
        int n = 3;
        int[][] expected = {
                {1, 3},
                {1, 2},
                {3, 2},
                {1, 3},
                {2, 1},
                {2, 3},
                {1, 3}
        };
        int[][] actual = new 하노이의_탑().solution(n);
        assertArrayEquals(expected, actual);
    }
}