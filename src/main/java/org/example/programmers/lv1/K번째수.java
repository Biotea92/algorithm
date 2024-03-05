package org.example.programmers.lv1;

import java.util.*;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int index = 0; index < commands.length; index++) {
            int[] command = commands[index];
            int i = command[0];
            int j = command[1];
            int k = command[2];
            List<Integer> tmp = new ArrayList<>();
            for (int l = i - 1; l < j ; l++) {
                tmp.add(array[l]);
            }
            Collections.sort(tmp);
            answer[index] = tmp.get(k - 1);
        }
        return answer;
    }

    public static void main(String[] args) {

        int[] solution = new K번째수().solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        System.out.println(Arrays.toString(solution));
    }
}
