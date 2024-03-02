package org.example.programmers.lv2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 수식_최대화Test {

    @Test
    void test() {
        // given
        String expression = "100-200*300-500+20";

        // when
        long result = new 수식_최대화().solution(expression);

        // then
        assertEquals(60420, result);
    }

    @Test
    void test2() {
        // given
        String expression = "50*6-3*2";

        // when
        long result = new 수식_최대화().solution(expression);

        // then
        assertEquals(300, result);
    }
}