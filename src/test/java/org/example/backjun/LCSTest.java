package org.example.backjun;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LCSTest {

    @Test
    void test() {
        String str1 = "ACAYKP";
        String str2 = "CAPCAK";
        int expected = 4;

        int actual = new LCS().solution(str1, str2);

        assertEquals(expected, actual);
    }
}