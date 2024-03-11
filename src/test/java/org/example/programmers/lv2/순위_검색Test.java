package org.example.programmers.lv2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 순위_검색Test {

    @DisplayName("")
    @Test
    void test() {
        // given
        String[] info = {
            "java backend junior pizza 150",
            "python frontend senior chicken 210",
            "python frontend senior chicken 150",
            "cpp backend senior pizza 260",
            "java backend junior chicken 80",
            "python backend senior chicken 50"
        };
        String[] query = {
            "java and backend and junior and pizza 100",
            "python and frontend and senior and chicken 200",
            "cpp and - and senior and pizza 250",
            "- and backend and senior and - 150",
            "- and - and - and chicken 100",
            "- and - and - and - 150"
        };
        // when
        int[] solution = new 순위_검색().solution(info, query);

        // then
        assertArrayEquals(new int[]{1, 1, 1, 1, 2, 4}, solution);
    }
}