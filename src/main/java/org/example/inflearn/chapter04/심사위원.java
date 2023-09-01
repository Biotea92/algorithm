package org.example.inflearn.chapter04;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 심사위원 {
    public int solution(int[] score, int k){
        Arrays.sort(score);
        int n = score.length;
        int minAverage = Integer.MAX_VALUE;

        for (int i = 0; i < n - k; i++) {
            int low = score[i];
            int high = score[i + k - 1];

            int sum = 0;

            if (high - low <= 10) {
                for (int j = i; j < i + k; j++) {
                    sum += score[j];
                }
                int avg = sum / k;
                minAverage = Math.min(minAverage, avg);
            }
        }
        return minAverage;
    }

    public static void main(String[] args){
        심사위원 T = new 심사위원();
        System.out.println(T.solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
        System.out.println(T.solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
        System.out.println(T.solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5));
        System.out.println(T.solution(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5));
    }
}
