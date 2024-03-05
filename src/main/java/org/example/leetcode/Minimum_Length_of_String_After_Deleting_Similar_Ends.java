package org.example.leetcode;

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

    public int minimumLength(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int i = 0;
        int j = n - 1;
        while (j > i) {
            if (ch[i] != ch[j])
                break;
            char c = ch[i];
            while (j >= i && ch[i] == c)
                i++;
            while (j >= i && ch[j] == c)
                j--;
        }
        return j - i + 1;
    }
}
