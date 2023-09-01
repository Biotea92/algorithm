package org.example.inflearn.chapter01;

import java.util.ArrayList;
import java.util.List;

public class 최대길이바이토닉수역 {

    public int solution(int[] nums){
        int answer = 0;

        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
                peaks.add(i);
            }
        }
        for (int x : peaks) {
            int left = x;
            int right = x;
            int count = 1;

            while (left - 1 >= 0 && nums[left-1] < nums[left]) {
                left--;
                count++;
            }

            while (right + 1 < nums.length && nums[right+1] < nums[right]) {
                right++;
                count++;
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }

    public static void main(String[] args){
        최대길이바이토닉수역 T = new 최대길이바이토닉수역();
        System.out.println(T.solution(new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
