package org.example.inflearn.chapter02;

import java.util.*;

public class 같은_빈도수_만들기 {

    public int[] solution(String s){
        int[] answer = new int[5];
        char[] chars = {'a', 'b', 'c', 'd', 'e'};

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c , map.getOrDefault(c, 0) + 1);
        }

        int max = 0;
        for (Integer value : map.values()) {
            max = Math.max(max, value);
        }

        for (int i = 0; i < chars.length; i++) {
            answer[i] = max - map.getOrDefault(chars[i], 0);
        }

        return answer;
    }

    public static void main(String[] args){
        같은_빈도수_만들기 T = new 같은_빈도수_만들기();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
