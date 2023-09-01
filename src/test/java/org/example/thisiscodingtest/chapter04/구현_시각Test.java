package org.example.thisiscodingtest.chapter04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 구현_시각Test {

    @Test
    void test() {
        구현_시각 구현_시각 = new 구현_시각();

        int n = 5;
        int solution = 구현_시각.solution(n);

        Assertions.assertEquals(11475, solution);
    }
}