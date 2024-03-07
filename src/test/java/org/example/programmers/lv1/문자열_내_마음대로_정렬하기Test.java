package org.example.programmers.lv1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 문자열_내_마음대로_정렬하기Test {

    @Test
    void test1() {
        문자열_내_마음대로_정렬하기 obj = new 문자열_내_마음대로_정렬하기();
        String[] strings = {"sun", "bed", "car"};
        int n = 1;
        String[] result = obj.solution(strings, n);
        assertArrayEquals(new String[]{"car", "bed", "sun"}, result);
    }

    @Test
    void test2() {
        문자열_내_마음대로_정렬하기 obj = new 문자열_내_마음대로_정렬하기();
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;
        String[] result = obj.solution(strings, n);
        assertArrayEquals(new String[]{"abcd", "abce", "cdx"}, result);
    }
}
