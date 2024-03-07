package org.example.programmers.lv3;

import java.util.*;

public class 불량_사용자 {

    private Set<Set<String>> banSet = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        String[][] bans = Arrays.stream(banned_id)
                .map(banned -> banned.replace("*", "."))
                .map(banned -> Arrays.stream(user_id)
                        .filter(id -> id.matches(banned))
                        .toArray(String[]::new))
                .toArray(String[][]::new);
        dfs(0, new HashSet<>(), bans);
        return banSet.size();
    }

    private void dfs(int index, Set<String> banned, String[][] bans) {
        if (index == bans.length) {
            banSet.add(new HashSet<>(banned));
            return;
        }

        for (String ban : bans[index]) {
            if (banned.contains(ban)) {
                continue;
            }
            banned.add(ban);
            dfs(index + 1, banned, bans);
            banned.remove(ban);
        }
    }
}
