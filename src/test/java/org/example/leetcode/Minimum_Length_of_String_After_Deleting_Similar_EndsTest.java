package org.example.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Minimum_Length_of_String_After_Deleting_Similar_EndsTest {

//
//    Example 1:
//
//    Input: s = "ca"
//    Output: 2
//    Explanation: You can't remove any characters, so the string stays as is.
//    Example 2:
//
//    Input: s = "cabaabac"
//    Output: 0
//    Explanation: An optimal sequence of operations is:
//            - Take prefix = "c" and suffix = "c" and remove them, s = "abaaba".
//            - Take prefix = "a" and suffix = "a" and remove them, s = "baab".
//            - Take prefix = "b" and suffix = "b" and remove them, s = "aa".
//            - Take prefix = "a" and suffix = "a" and remove them, s = "".
//    Example 3:
//
//    Input: s = "aabccabba"
//    Output: 3
//    Explanation: An optimal sequence of operations is:
//            - Take prefix = "aa" and suffix = "a" and remove them, s = "bccabb".
//            - Take prefix = "b" and suffix = "bb" and remove them, s = "cca".
//
    @Test
    void minimumLength() {
        // given
        String s = "ca";

        // when
        int result = new Minimum_Length_of_String_After_Deleting_Similar_Ends().minimumLength(s);

        // then
        assertEquals(2, result);
    }

    @Test
    void minimumLength2() {
        // given
        String s = "cabaabac";

        // when
        int result = new Minimum_Length_of_String_After_Deleting_Similar_Ends().minimumLength(s);

        // then
        assertEquals(0, result);
    }

    @Test
    void minimumLength3() {
        // given
        String s = "aabccabba";

        // when
        int result = new Minimum_Length_of_String_After_Deleting_Similar_Ends().minimumLength(s);

        // then
        assertEquals(3, result);
    }
}
