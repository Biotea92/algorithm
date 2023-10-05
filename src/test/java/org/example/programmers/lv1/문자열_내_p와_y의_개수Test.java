package org.example.programmers.lv1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 문자열_내_p와_y의_개수Test {

    @Test
    void test1() {
        // given
        String s = "pPoooyY";
        boolean expected = true;

        // when
        boolean actual = new 문자열_내_p와_y의_개수().solution(s);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        // given
        String s = "Pyy";
        boolean expected = false;

        // when
        boolean actual = new 문자열_내_p와_y의_개수().solution(s);

        // then
        assertEquals(expected, actual);
    }
}