package org.example.programmers.lv2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class 쿼드압축_후_개수_세기Test {
    private static 쿼드압축_후_개수_세기 obj;

    @BeforeEach
    public void init() {
        obj = new 쿼드압축_후_개수_세기();
    }

    @Test
    void test1() {
        int[][] arr = {
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 1}
        };
        int[] expected = {4, 9};
        int[] actual = obj.solution(arr);
        assertArrayEquals(expected, actual);
    }

    @Test
    void test2() {
        int[][] arr = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 1, 1}
        };
        int[] expected = {10, 15};
        int[] actual = obj.solution(arr);
        assertArrayEquals(expected, actual);
    }

    @Test
    void test3() {
        int[][] arr = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        int[] expected = {0, 1};
        int[] actual = obj.solution(arr);
        assertArrayEquals(expected, actual);
    }

    @Test
    void test4() {
        int[][] arr = {
            {1}
        };
        int[] expected = {0, 1};
        int[] actual = obj.solution(arr);
        assertArrayEquals(expected, actual);
    }

    @Test
    void test5() {
        int[][] arr = {
                {0}
        };
        int[] expected = {1, 0};
        int[] actual = obj.solution(arr);
        assertArrayEquals(expected, actual);
    }
}