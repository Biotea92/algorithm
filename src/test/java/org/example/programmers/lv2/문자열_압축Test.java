package org.example.programmers.lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 문자열_압축Test {

    @Test
    void test1() {
        // given
        String s = "aabbaccc";
        int expected = 7;
        // 2a2ba3c
        // when
        int actual = new 문자열_압축().solution(s);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        // given
        String s = "ababcdcdababcdcd";
        int expected = 9;
        // 2ababcdcd
        // when
        int actual = new 문자열_압축().solution(s);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        // given
        String s = "abcabcdede";
        int expected = 8;

        // when
        int actual = new 문자열_압축().solution(s);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void test4() {
        // given
        String s = "abcabcabcabcdededededede";
        int expected = 14;

        // when
        int actual = new 문자열_압축().solution(s);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void test5() {
        // given
        String s = "xababcdcdababcdcd";
        int expected = 17;

        // when
        int actual = new 문자열_압축().solution(s);

        // then
        assertEquals(expected, actual);
    }
}