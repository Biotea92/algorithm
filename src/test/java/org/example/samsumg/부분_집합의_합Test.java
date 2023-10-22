package org.example.samsumg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 부분_집합의_합Test {

    @Test
    void test1() {
        int N = 10;
        int K = 7;
        int expected = 5;
        int actual = new 부분_집합의_합().solution(N, K);
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int N = 10;
        int K = 53;
        int expected = 1;
        int actual = new 부분_집합의_합().solution(N, K);
        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        int N = 100;
        int K = 5050;
        int expected = 1;
        int actual = new 부분_집합의_합().solution(N, K);
        assertEquals(expected, actual);
    }
}