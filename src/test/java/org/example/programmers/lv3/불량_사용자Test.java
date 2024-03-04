package org.example.programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 불량_사용자Test {

    @Test
    void test1() {
        // given
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};

        // when
        int solution = new 불량_사용자().solution(user_id, banned_id);

        // then
        Assertions.assertEquals(2, solution);
    }

    @Test
    void test2() {
        // given
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"*rodo", "*rodo", "******"};

        // when
        int solution = new 불량_사용자().solution(user_id, banned_id);

        // then
        Assertions.assertEquals(2, solution);
    }

    @Test
    void test3() {
        // given
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};

        // when
        int solution = new 불량_사용자().solution(user_id, banned_id);

        // then
        Assertions.assertEquals(3, solution);
    }

}