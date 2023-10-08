package org.example.programmers.lv1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 신규_아이디_추천Test {

    @Test
    void test1() {
        // given
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        String expected = "bat.y.abcdefghi";

        // when
        String actual = new 신규_아이디_추천().solution(new_id);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        // given
        String new_id = "z-+.^.";
        String expected = "z--";

        // when
        String actual = new 신규_아이디_추천().solution(new_id);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        // given
        String new_id = "=.=";
        String expected = "aaa";

        // when
        String actual = new 신규_아이디_추천().solution(new_id);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void test4() {
        // given
        String new_id = "123_.def";
        String expected = "123_.def";

        // when
        String actual = new 신규_아이디_추천().solution(new_id);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void test5() {
        // given
        String new_id = "abcdefghijklmn.p";
        String expected = "abcdefghijklmn";

        // when
        String actual = new 신규_아이디_추천().solution(new_id);

        // then
        assertEquals(expected, actual);
    }
}