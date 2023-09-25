package org.example.programmers.lv1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 이상한_문자_만들기Test {

    @Test
    void test1() {
        이상한_문자_만들기 c = new 이상한_문자_만들기();
        assertEquals("TrY HeLlO WoRlD", c.solution("try hello world"));
    }
}