package org.example.samsumg;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 청소년_상어Test {

    청소년_상어 청소년_상어;

    @BeforeEach
    void beforeEach() {
        청소년_상어 = new 청소년_상어();
    }

    @Test
    void test1() {
        int[][] map = new int[4][];
        map[0] = new int[]{7, 6, 2, 3, 15, 6, 9, 8};
        map[1] = new int[]{3, 1, 1, 8, 14, 7, 10, 1};
        map[2] = new int[]{6, 1, 13, 6, 4, 3, 11, 4};
        map[3] = new int[]{16, 1, 8, 7, 5, 2, 12, 2};

        assertEquals(33, 청소년_상어.solution(map));
    }

    @Test
    void test2() {
        int[][] map = new int[4][];
        map[0] = new int[]{16, 7, 1, 4, 4, 3, 12, 8};
        map[1] = new int[]{14, 7, 7, 6, 3, 4, 10, 2};
        map[2] = new int[]{5, 2, 15, 2, 8, 3, 6, 4};
        map[3] = new int[]{11, 8, 2, 4, 13, 5, 9, 4};

        assertEquals(43, 청소년_상어.solution(map));
    }

    @Test
    void test3() {
        int[][] map = new int[4][];
        map[0] = new int[]{12, 6, 14, 5, 4, 5, 6, 7};
        map[1] = new int[]{15, 1, 11, 7, 3, 7, 7, 5};
        map[2] = new int[]{10, 3, 8, 3, 16, 6, 1, 1};
        map[3] = new int[]{5, 8, 2, 7, 13, 6, 9, 2};

        assertEquals(76, 청소년_상어.solution(map));
    }

    @Test
    void test4() {
        int[][] map = new int[4][];
        map[0] = new int[]{2, 6, 10, 8, 6, 7, 9, 4};
        map[1] = new int[]{1, 7, 16, 6, 4, 2, 5, 8};
        map[2] = new int[]{3, 7, 8, 6, 7, 6, 14, 8};
        map[3] = new int[]{12, 7, 15, 4, 11, 3, 13, 3};

        assertEquals(39, 청소년_상어.solution(map));
    }
}