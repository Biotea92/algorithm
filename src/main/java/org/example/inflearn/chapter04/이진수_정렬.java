package org.example.inflearn.chapter04;

import java.util.Arrays;

public class 이진수_정렬 {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length];

        int[][] res = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            char[] chars = Integer.toBinaryString(nums[i]).toCharArray();
            for (char c : chars) {
                if (c == '1') {
                    count++;
                }
            }
            res[i][0] = nums[i];
            res[i][1] = count;
        }

        Arrays.sort(res, (a,b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        for (int i = 0; i < res.length; i++) {
            answer[i] = res[i][0];
        }

        return answer;
    }

    public static void main(String[] args){
        이진수_정렬 T = new 이진수_정렬();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}
