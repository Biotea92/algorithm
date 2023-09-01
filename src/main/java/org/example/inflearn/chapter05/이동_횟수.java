package org.example.inflearn.chapter05;

import java.util.Arrays;

public class 이동_횟수 {
    public int solution(int[] nums){
        int answer = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        while(right >= left) {
            if (nums[left] + nums[right] <= 5) {
                answer++;
                right--;
                left++;
            } else {
                right--;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        이동_횟수 T = new 이동_횟수();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }
}
