package org.example.programmers.lv1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 문자열_다루기_기본Test {

    @Test
    void test1() {
        // given
        String s = "a234";
        boolean expected = false;

        // when
        boolean actual = new 문자열_다루기_기본().solution(s);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        // given
        String s = "1234";
        boolean expected = true;

        // when
        boolean actual = new 문자열_다루기_기본().solution(s);

        // then
        assertEquals(expected, actual);
    }
}