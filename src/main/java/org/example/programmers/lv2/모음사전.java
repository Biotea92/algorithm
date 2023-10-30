package org.example.programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class 모음사전 {

    private final String[] vowels = {"A", "E", "I", "O", "U"};
    private final Map<String, Integer> map = new HashMap<>();
    private static int index = 0;

    public int solution(String word) {
        generateDictionary("");
        return map.get(word);
    }

    private void generateDictionary(String word) {
        map.put(word, index);
        index++;

        if (word.length() == 5) {
            return;
        }

        for (String vowel : vowels) {
            generateDictionary(word + vowel);
        }
    }
}
