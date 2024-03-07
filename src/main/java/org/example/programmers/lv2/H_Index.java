package org.example.programmers.lv2;

import java.util.Arrays;

public class H_Index {

    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int h = n; h >= 1; h--) {
            if (getHIndexIsValid(citations, h)) {
                return h;
            }
        }
        return citations[0];
    }

    private boolean getHIndexIsValid(int[] citations, int h) {
        int i = citations.length - h;
        return citations[i] >= h;
    }
}
