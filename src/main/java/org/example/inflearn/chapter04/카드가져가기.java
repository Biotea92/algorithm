package org.example.inflearn.chapter04;

import java.util.*;

public class 카드가져가기 {
    public int solution(int[] nums, int k){
        int answer = 0;
        int n = nums.length;
        Integer[] tmp = Arrays.stream(nums)
                .boxed()
                .toArray(Integer[]::new);
        Arrays.sort(tmp, (a, b) -> b - a);

        List<Integer> diff = new ArrayList<>(n/2);

        for (int i = 0; i < n; i += 2) {
            diff.add(tmp[i] - tmp[i+1]);
            answer += tmp[i+1];
        }

        diff.sort(Comparator.reverseOrder());

        for (int i = 0; i < k; i++) {
            answer += diff.get(i);
        }

        return answer;
    }

    public static void main(String[] args){
        카드가져가기 T = new 카드가져가기();
        System.out.println(T.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
        System.out.println(T.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
        System.out.println(T.solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
        System.out.println(T.solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
        System.out.println(T.solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
    }
}
