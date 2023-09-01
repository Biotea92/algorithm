package org.example.inflearn.chapter02;

import java.util.*;

public class 한번만사용한최초문자 {
    public int solution(String s){
        Map<Character, Integer> map = new HashMap<>();

        for (char aChar : s.toCharArray()) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1)
                return i + 1;
        }
        return -1;
    }

    public static void main(String[] args){
        한번만사용한최초문자 T = new 한번만사용한최초문자();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}
