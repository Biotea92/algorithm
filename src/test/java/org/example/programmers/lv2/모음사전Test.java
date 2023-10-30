package org.example.programmers.lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 모음사전Test {


    @Test
    void test1() {
        String word = "AAAAE";
        int expected = 6;
        int actual = new 모음사전().solution(word);
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        String word = "AAAE";
        int expected = 10;
        int actual = new 모음사전().solution(word);
        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        String word = "I";
        int expected = 1563;
        int actual = new 모음사전().solution(word);
        assertEquals(expected, actual);
    }

    @Test
    void test4() {
        String word = "EIO";
        int expected = 1189;
        int actual = new 모음사전().solution(word);
        assertEquals(expected, actual);
    }
}