package org.example.thisiscodingtest.chapter04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 구현_게임_개발Test {

    @Test
    void test() {
        구현_게임_개발 구현_게임_개발 = new 구현_게임_개발();

        int[] map = {4,4};
        int[] location = {1,1,0};
        int[] first = {1,1,1,1};
        int[] second = {1,0,0,1};
        int[] third = {1,1,0,1};
        int[] forth = {1,1,1,1};
        int solution = 구현_게임_개발.solution(map, location, first, second, third, forth);

        Assertions.assertEquals(3, solution);
    }
}