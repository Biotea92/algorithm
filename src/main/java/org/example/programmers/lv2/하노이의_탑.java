package org.example.programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class 하노이의_탑 {

    private final List<int[]> process = new ArrayList<>();
    public int[][] solution(int n) {
        hanoi(n, 1, 3);
        return process.toArray(new int[0][]);
    }

    private void hanoi(int n, int from, int to) {
        if (n == 1) {
            process.add(new int[]{from, to});
            return;
        }
        int empty = 6 - from - to;
        hanoi(n - 1, from, empty);
        hanoi(1, from, to);
        hanoi(n - 1, empty, to);
    }
}
