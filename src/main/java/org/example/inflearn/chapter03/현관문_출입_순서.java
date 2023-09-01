package org.example.inflearn.chapter03;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class 현관문_출입_순서 {
    public int[] solution(int[] arrival, int[] state){
        int[] answer = {};
        Deque<Integer> enter = new LinkedList<>();
        Deque<Integer> exit = new LinkedList<>();

        return answer;
    }

    public static void main(String[] args){
        현관문_출입_순서 T = new 현관문_출입_순서();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}
