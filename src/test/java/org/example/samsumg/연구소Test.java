package org.example.samsumg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 연구소Test {

    @Test
    void test1() {
        연구소 연구소 = new 연구소();
        int N = 7;
        int M = 7;
        int[][] mapShape = new int[N][];
        mapShape[0] = new int[]{2, 0, 0, 0, 1, 1, 0};
        mapShape[1] = new int[]{0, 0, 1, 0, 1, 2, 0};
        mapShape[2] = new int[]{0, 1, 1, 0, 1, 0, 0};
        mapShape[3] = new int[]{0, 1, 0, 0, 0, 0, 0};
        mapShape[4] = new int[]{0, 0, 0, 0, 0, 1, 1};
        mapShape[5] = new int[]{0, 1, 0, 0, 0, 0, 0};
        mapShape[6] = new int[]{0, 1, 0, 0, 0, 0, 0};

        int result = 연구소.solution(N, M, mapShape);
        assertEquals(27, result);
    }

    @Test
    void test2() {
        연구소 연구소 = new 연구소();
        int N = 4;
        int M = 6;
        int[][] mapShape = new int[N][];
        mapShape[0] = new int[]{0, 0, 0, 0, 0, 0};
        mapShape[1] = new int[]{1, 0, 0, 0, 0, 2};
        mapShape[2] = new int[]{1, 1, 1, 0, 0, 2};
        mapShape[3] = new int[]{0, 0, 0, 0, 0, 2};

        int result = 연구소.solution(N, M, mapShape);
        assertEquals(9, result);
    }

    @Test
    void test3() {
        연구소 연구소 = new 연구소();
        int N = 8;
        int M = 8;
        int[][] mapShape = new int[N][];
        mapShape[0] = new int[]{2, 0, 0, 0, 0, 0, 0, 2};
        mapShape[1] = new int[]{2, 0, 0, 0, 0, 0, 0, 2};
        mapShape[2] = new int[]{2, 0, 0, 0, 0, 0, 0, 2};
        mapShape[3] = new int[]{2, 0, 0, 0, 0, 0, 0, 2};
        mapShape[4] = new int[]{2, 0, 0, 0, 0, 0, 0, 2};
        mapShape[5] = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        mapShape[6] = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        mapShape[7] = new int[]{0, 0, 0, 0, 0, 0, 0, 0};

        int result = 연구소.solution(N, M, mapShape);
        assertEquals(3, result);
    }

}