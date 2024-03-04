package org.example.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Bag_of_TokensTest {
/*

    Example 1:

    Input: tokens = [100], power = 50

    Output: 0

    Explanation: Since your score is 0 initially, you cannot play the token face-down.
    You also cannot play it face-up since your power (50) is less than tokens[0] (100).

    Example 2:

    Input: tokens = [200,100], power = 150

    Output: 1

    Explanation: Play token1 (100) face-up, reducing your power to 50 and increasing your score to 1.

    There is no need to play token0, since you cannot play it face-up to add to your score. The maximum score achievable is 1.

    Example 3:

    Input: tokens = [100,200,300,400], power = 200

    Output: 2

    Explanation: Play the tokens in this order to get a score of 2:

    Play token0 (100) face-up, reducing power to 100 and increasing score to 1.
    Play token3 (400) face-down, increasing power to 500 and reducing score to 0.
    Play token1 (200) face-up, reducing power to 300 and increasing score to 1.
    Play token2 (300) face-up, reducing power to 0 and increasing score to 2.
    The maximum score achievable is 2.

*/

    @Test
    void test1() {
        // given
        int[] tokens = {100};
        int power = 50;

        // when
        int result = new Bag_of_Tokens().bagOfTokensScore(tokens, power);

        // then
        assertEquals(0, result);
    }

    @Test
    void test2() {
        // given
        int[] tokens = {200, 100};
        int power = 150;

        // when
        int result = new Bag_of_Tokens().bagOfTokensScore(tokens, power);

        // then
        assertEquals(1, result);
    }

    @Test
    void test3() {
        // given
        int[] tokens = {100, 200, 300, 400};
        int power = 200;

        // when
        int result = new Bag_of_Tokens().bagOfTokensScore(tokens, power);

        // then
        assertEquals(2, result);
    }
}
