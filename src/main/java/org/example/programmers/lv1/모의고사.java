package org.example.programmers.lv1;

import java.util.*;
import java.util.stream.IntStream;

public class 모의고사 {

    private static final int[][] RULES = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    public int[] solution(int[] answers) {
        int[] corrects = new int[3];
        int max = 0;

        for (int problem = 0; problem < answers.length; problem++) {
            int answer = answers[problem];
            for (int person = 0; person < 3; person++) {
                int picked = getPicked(person, problem);
                if (answer == picked) {
                    corrects[person]++;
                    max = Math.max(max, corrects[person]);
                }
            }
        }

        final int maxCorrect = max;
        return IntStream.range(0, 3)
                .filter(i -> corrects[i] == maxCorrect)
                .map(i -> i + 1)
                .toArray();
    }

    public int getPicked(int person, int problem) {
        int[] rule = RULES[person];
        int index = problem % rule.length;
        return rule[index];
    }
}
