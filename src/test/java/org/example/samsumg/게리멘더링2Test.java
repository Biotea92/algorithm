package org.example.samsumg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 게리멘더링2Test {

    @Test
    void test1() {
        게리멘더링2 게리멘더링2 = new 게리멘더링2();
        int n = 6;
        int[][] population = new int[n][];
        population[0] = new int[]{1, 2, 3, 4, 1, 6};
        population[1] = new int[]{7, 8, 9, 1, 4, 2};
        population[2] = new int[]{2, 3, 4, 1, 1, 3};
        population[3] = new int[]{6, 6, 6, 6, 9, 4};
        population[4] = new int[]{9, 1, 9, 1, 9, 5};
        population[5] = new int[]{1, 1, 1, 1, 9, 9};

        assertEquals(18, 게리멘더링2.solution(n, population));
    }

    @Test
    void test2() {
        게리멘더링2 게리멘더링2 = new 게리멘더링2();
        int n = 6;
        int[][] population = new int[n][];
        population[0] = new int[]{5, 5, 5, 5, 5, 5};
        population[1] = new int[]{5, 5, 5, 5, 5, 5};
        population[2] = new int[]{5, 5, 5, 5, 5, 5};
        population[3] = new int[]{5, 5, 5, 5, 5, 5};
        population[4] = new int[]{5, 5, 5, 5, 5, 5};
        population[5] = new int[]{5, 5, 5, 5, 5, 5};

        assertEquals(20, 게리멘더링2.solution(n, population));
    }

    @Test
    void test3() {
        게리멘더링2 게리멘더링2 = new 게리멘더링2();
        int n = 8;
        int[][] population = new int[n][];
        population[0] = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        population[1] = new int[]{2, 3, 4, 5, 6, 7, 8, 9};
        population[2] = new int[]{3, 4, 5, 6, 7, 8, 9, 1};
        population[3] = new int[]{4, 5, 6, 7, 8, 9, 1, 2};
        population[4] = new int[]{5, 6, 7, 8, 9, 1, 2, 3};
        population[5] = new int[]{6, 7, 8, 9, 1, 2, 3, 4};
        population[6] = new int[]{7, 8, 9, 1, 2, 3, 4, 5};
        population[7] = new int[]{8, 9, 1, 2, 3, 4, 5, 6};

        assertEquals(23, 게리멘더링2.solution(n, population));
    }
}