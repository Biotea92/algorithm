package org.example.backjun;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 펠린드롬_만들기Test {

    @Test
    void test1() {
        int[] arr = {1, 2, 3};
        int expected = 2;
        int actual = new 펠린드롬_만들기().solution(arr);
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int[] arr = {1, 2, 1};
        int expected = 0;
        int actual = new 펠린드롬_만들기().solution(arr);
        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        int[] arr = {1, 1, 1, 1};
        int expected = 0;
        int actual = new 펠린드롬_만들기().solution(arr);
        assertEquals(expected, actual);
    }

    @Test
    void test4() {
        int[] arr = {1, 2, 3, 4, 2};
        int expected = 2;
        int actual = new 펠린드롬_만들기().solution(arr);
        assertEquals(expected, actual);
    }
}