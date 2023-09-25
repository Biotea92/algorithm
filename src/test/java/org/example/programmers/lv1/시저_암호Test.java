package org.example.programmers.lv1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 시저_암호Test {

    @Test
    void test1() {
        시저_암호 c = new 시저_암호();
        assertEquals("BC", c.solution("AB", 1));
    }

    @Test
    void test2() {
        시저_암호 c = new 시저_암호();
        assertEquals("a", c.solution("z", 1));
    }

    @Test
    void test3() {
        시저_암호 c = new 시저_암호();
        assertEquals("e F d", c.solution("a B z", 4));
    }
}