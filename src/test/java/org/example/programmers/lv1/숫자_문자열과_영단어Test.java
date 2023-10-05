package org.example.programmers.lv1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 숫자_문자열과_영단어Test {


    @Test
    void test1() {
        // given
        String s = "one4seveneight";
        int expected = 1478;

        // when
        int actual = new 숫자_문자열과_영단어().solution(s);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        // given
        String s = "23four5six7";
        int expected = 234567;

        // when
        int actual = new 숫자_문자열과_영단어().solution(s);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        // given
        String s = "2three45sixseven";
        int expected = 234567;

        // when
        int actual = new 숫자_문자열과_영단어().solution(s);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void test4() {
        // given
        String s = "123";
        int expected = 123;

        // when
        int actual = new 숫자_문자열과_영단어().solution(s);

        // then
        assertEquals(expected, actual);
    }
}