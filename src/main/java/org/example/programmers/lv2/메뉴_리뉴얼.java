package org.example.programmers.lv2;

import java.util.*;
import java.util.stream.Collectors;

public class 메뉴_리뉴얼 {

    private static Map<String, Integer> countMap = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        for (int count : course) {
            for (String order : orders) {
                String[] strs = order.split("");
                if (order.length() < count)
                    continue;
                dfs(strs, new boolean[strs.length], count, new HashSet<>(), 0);
            }
        }

        List<String> result = new ArrayList<>();
        for (String s : countMap.keySet()) {
            if (countMap.get(s) > 1)
                result.add(s);
        }

        String[] array = result.toArray(new String[0]);
        Arrays.sort(array);
        return array;
    }

    public void dfs(String[] strs, boolean[] visited, int count, Set<String> tmp, int start) {
        if (tmp.size() >= count || tmp.size() >= 10) {
            String courseName = tmp.stream()
                    .sorted()
                    .collect(Collectors.joining());
            countMap.put(courseName, countMap.getOrDefault(courseName, 0) + 1);
            return;
        }

        for (int i = start; i < strs.length; i++) {
            if (!visited[i]) {
                String s = strs[i];
                tmp.add(s);
                visited[i] = true;
                dfs(strs, visited, count, tmp, i + 1);
                tmp.remove(s);
                visited[i] = false;
            }
        }
    }
}
