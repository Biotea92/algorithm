package org.example.programmers.lv1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 문자열_내림차순으로_배치하기Test {

    @Test
    void solution() {
        문자열_내림차순으로_배치하기 obj = new 문자열_내림차순으로_배치하기();
        String s = "Zbcdefg";
        String result = obj.solution(s);
        assertEquals("gfedcbZ", result);
    }

}
