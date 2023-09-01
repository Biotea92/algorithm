package org.example.thisiscodingtest;

import org.example.thisiscodingtest.chapter04.구현_상하좌우;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class 구현_상하좌우Test {

    @Test
    void test() {
        구현_상하좌우 구현_상하좌우 = new 구현_상하좌우();

        int n = 5;
        String[] moves = new String[] {"R","R","R","U","D","D"};
        int[] solution = 구현_상하좌우.solution(n, moves);

        Assertions.assertEquals(solution[0], 3);
        Assertions.assertEquals(solution[1], 4);
    }
}