package org.example.backjun;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 동전1Test {

    @Test
    void test() {
        동전1 동전1 = new 동전1();
        int[] coins = {1, 2, 5};
        int k = 10;

        assertEquals(10, 동전1.solution(coins, k));
    }
}