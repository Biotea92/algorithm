package org.example.inflearn.chapter04;

import java.util.*;

public class 수열찾기 {

    public int[] solution(int[] nums){
        int[] answer = new int[nums.length / 2];
        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x , map.getOrDefault(x, 0) + 1);
        }

        int index = 0;
        for (int x : nums) {
            if (map.get(x) == 0) {
                continue;
            }

            answer[index] = x;
            index++;
            map.put(x, map.get(x)-1);
            map.put(x*2, map.get(x*2) - 1);
        }


        return answer;
    }

    public static void main(String[] args){
        수열찾기 T = new 수열찾기();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
