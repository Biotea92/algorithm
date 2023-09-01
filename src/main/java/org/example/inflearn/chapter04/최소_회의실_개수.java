package org.example.inflearn.chapter04;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 최소_회의실_개수 {

    public int solution(int[][] meetings){
        int answer = 0;

        List<List<Integer>> list = new LinkedList<>();

        for (int[] x : meetings) {
            list.add(List.of(x[0], 1));
            list.add(List.of(x[1], 2));
        }
        list.sort((a,b) -> a.get(0) == b.get(0) ? b.get(1) - a.get(1) : a.get(0) - b.get(0));

        System.out.println("list = " + list);

        int count = 0;
        for (List<Integer> x : list) {
            if (x.get(1) == 1) {
                count++;
            } else {
                count--;
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }

    public static void main(String[] args){
        최소_회의실_개수 T = new 최소_회의실_개수();
        System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
        System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}
