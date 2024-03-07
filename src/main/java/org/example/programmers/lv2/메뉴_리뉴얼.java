package org.example.programmers.lv2;

import java.util.*;
import java.util.stream.Collectors;

public class 메뉴_리뉴얼 {

    private static Map<Integer, Map<String, Integer>> countMap = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        for (int count : course) {
            for (String order : orders) {
                String[] strs = order.split("");
                if (order.length() < count)
                    continue;
                dfs(strs, new boolean[strs.length], count, new HashSet<>(), 0);
            }
        }

        List<String> answer = new ArrayList<>();

        for (int count : countMap.keySet()) {
            Map<String, Integer> map = countMap.get(count);
            int max = 0;
            for (String key : map.keySet()) {
                max = Math.max(max, map.get(key));
            }
            if (max < 2)
                continue;
            for (String key : map.keySet()) {
                if (map.get(key) == max) {
                    answer.add(key);
                }
            }
        }
        return answer.stream()
                .sorted()
                .toArray(String[]::new);
    }

    private void dfs(String[] strs, boolean[] visited, int count, Set<String> tmp, int start) {
        if (tmp.size() >= count || tmp.size() >= 10) {
            Map<String, Integer> tmpMap = countMap.getOrDefault(tmp.size(), new HashMap<>());
            String courseName = tmp.stream()
                    .sorted()
                    .collect(Collectors.joining());
            tmpMap.put(courseName, tmpMap.getOrDefault(courseName, 0) + 1);
            countMap.put(tmp.size(), tmpMap);
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
