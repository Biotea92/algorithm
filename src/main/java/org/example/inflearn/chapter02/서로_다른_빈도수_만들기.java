package org.example.inflearn.chapter02;

import java.util.*;
import java.util.stream.Collectors;

public class 서로_다른_빈도수_만들기 {

    public int solution(String s) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Character character : map.keySet()) {
            while (set.contains(map.get(character))) {
                answer++;
                map.put(character, map.get(character) - 1);
            }
            if (map.get(character) == 0)
                continue;
            set.add(map.get(character));
        }

        System.out.println("set = " + set);
        return answer;
    }

    public static void main(String[] args) {
        서로_다른_빈도수_만들기 T = new 서로_다른_빈도수_만들기();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}
