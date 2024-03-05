package org.example.leetcode;

import java.util.Arrays;

public class Minimum_Length_of_String_After_Deleting_Similar_Ends {

//
//    Given a string s consisting only of characters 'a', 'b', and 'c'. You are asked to apply the following algorithm on the string any number of times:
//
//    1.Pick a non-empty prefix from the string s where all the characters in the prefix are equal.
//    2.Pick a non-empty suffix from the string s where all the characters in this suffix are equal.
//    3.The prefix and the suffix should not intersect at any index.
//    4.The characters from the prefix and suffix must be the same.
//    5.Delete both the prefix and the suffix.
//
//    Return the minimum length of s after performing the above operation any number of times (possibly zero times).
//
//    1 <= s.length <= 105
//    s only consists of characters 'a', 'b', and 'c'.
    private final static String NOT_MATCH_STR = "z";

    public int minimumLength(String s) {
        String[] chars = s.split("");
        reduce(chars, 0, chars.length - 1);
        return Arrays.stream(chars)
                .filter(c -> !c.equals(NOT_MATCH_STR))
                .toArray()
                .length;
    }

    public void reduce(String[] chars, int left, int right) {
        if (left > right) {
            return;
        }

        if (chars[left].equals(chars[right])) {
            String c = chars[left];
            int leftTmp = -1;
            for (int i = left; i < right; i++) {
                if (chars[i].equals(c)) {
                    leftTmp = i;
                    chars[i] = NOT_MATCH_STR;
                } else {
                    break;
                }
            }
            int rightTmp = -1;
            for (int i = right; i > left; i--) {
                if (chars[i].equals(c)) {
                    rightTmp = i;
                    chars[i] = NOT_MATCH_STR;
                } else {
                    break;
                }
            }
            reduce(chars, leftTmp + 1, rightTmp - 1);
        }
    }
}
