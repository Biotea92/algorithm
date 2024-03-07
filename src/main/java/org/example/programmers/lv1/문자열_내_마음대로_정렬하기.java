package org.example.programmers.lv1;

import java.util.Arrays;

public class 문자열_내_마음대로_정렬하기 {

    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (a, b) -> {
            if (a.charAt(n) == b.charAt(n)) {
                return a.compareTo(b);
            }
            return Character.compare(a.charAt(n), b.charAt(n));
        });
        return strings;
    }
}
