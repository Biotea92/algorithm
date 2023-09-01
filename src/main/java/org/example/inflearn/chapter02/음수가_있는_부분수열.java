package org.example.inflearn.chapter02;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class 음수가_있는_부분수열 {

    // O(n2)임;
    public int solution1(int[] nums, int m){
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            int result = nums[i];

            if (result == m) {
                answer++;
            }

            for (int j = i + 1; j < nums.length; j++) {
                result += nums[j];
                if (result == m) {
                    answer++;
                }
            }
        }

        return answer;
    }

    // O(n)
    public int solution(int[] nums, int m){
        int answer = 0;
        HashMap<Integer, Integer> nH = new HashMap<>();
        int sum = 0;
        nH.put(0, 1);

        for(int x : nums){
            sum += x;
//            System.out.println("sum = " + sum);
//            System.out.println("nH = " + nH);
//            System.out.println("(sum-m) = " + (sum-m));
//            System.out.println("===========================");
            if(nH.containsKey(sum-m))
                answer += nH.get(sum-m);

            nH.put(sum, nH.getOrDefault(sum, 0) + 1);

        }
        return answer;
    }

    public static void main(String[] args){
        음수가_있는_부분수열 T = new 음수가_있는_부분수열();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}
