package org.example.samsumg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 컨베이어_벨트_위의_로봇Test {

    @Test
    void test1() {
        컨베이어_벨트_위의_로봇 컨베이어_벨트_위의_로봇 = new 컨베이어_벨트_위의_로봇();
        int n = 3;
        int k = 2;
        int[] a = new int[]{1, 2, 1, 2, 1, 2};
        assertEquals(2, 컨베이어_벨트_위의_로봇.solution(n, k, a));
    }

    @Test
    void test2() {
        컨베이어_벨트_위의_로봇 컨베이어_벨트_위의_로봇 = new 컨베이어_벨트_위의_로봇();
        int n = 3;
        int k = 6;
        int[] a = new int[]{10, 10, 10, 10, 10, 10};
        assertEquals(31, 컨베이어_벨트_위의_로봇.solution(n, k, a));
    }

    @Test
    void test3() {
        컨베이어_벨트_위의_로봇 컨베이어_벨트_위의_로봇 = new 컨베이어_벨트_위의_로봇();
        int n = 4;
        int k = 5;
        int[] a = new int[]{10, 1, 10, 6, 3, 4, 8, 2};
        assertEquals(24, 컨베이어_벨트_위의_로봇.solution(n, k, a));
    }

    @Test
    void test4() {
        컨베이어_벨트_위의_로봇 컨베이어_벨트_위의_로봇 = new 컨베이어_벨트_위의_로봇();
        int n = 5;
        int k = 8;
        int[] a = new int[]{100, 99, 60, 80, 30, 20, 10, 89, 99, 100};
        assertEquals(472, 컨베이어_벨트_위의_로봇.solution(n, k, a));
    }
}