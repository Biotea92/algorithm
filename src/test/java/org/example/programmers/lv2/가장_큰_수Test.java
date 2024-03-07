package org.example.programmers.lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 가장_큰_수Test {

    @Test
    void solution() {
        가장_큰_수 obj = new 가장_큰_수();
        int[] numbers = {6, 10, 2};
        String result = obj.solution(numbers);
        assertEquals("6210", result);
    }

    @Test
    void solution2() {
        가장_큰_수 obj = new 가장_큰_수();
        int[] numbers = {3, 30, 34, 5, 9};
        String result = obj.solution(numbers);
        assertEquals("9534330", result);
    }
}
