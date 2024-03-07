package org.example.programmers.lv1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class 문자열_내림차순으로_배치하기 {

    public String solution(String s) {
        return Arrays.stream(s.split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining());
    }
}
