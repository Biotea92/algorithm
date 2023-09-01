package org.example.thisiscodingtest.chapter04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 구현_왕실의_나이트Test {

    @Test
    void test1() {
        구현_왕실의_나이트 구현_왕실의_나이트 = new 구현_왕실의_나이트();

        String location = "a1";
        int solution = 구현_왕실의_나이트.solution(location);

        Assertions.assertEquals(2, solution);
    }

    @Test
    void test2() {
        구현_왕실의_나이트 구현_왕실의_나이트 = new 구현_왕실의_나이트();

        String location = "c2";
        int solution = 구현_왕실의_나이트.solution(location);

        Assertions.assertEquals(6, solution);
    }
}