package org.example.programmers.lv3;

import java.util.*;

public class 불량_사용자 {

    private Set<Set<String>> combinations = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        Map<String, List<String>> banMatchingUserMap = getBanMatchingUserMap(user_id, banned_id);
        findValidCombinations(new HashSet<>(), banMatchingUserMap, 0, banned_id);
        return combinations.size();
    }

    private Map<String, List<String>> getBanMatchingUserMap(String[] user_id, String[] banned_id) {
        Map<String, List<String>> banMatchingUserMap = new HashMap<>();
        for (String banId : banned_id) {
            List<String> matchingUsers = new ArrayList<>();
            for (String userId : user_id) {
                if (banId.length() == userId.length() && isBannedId(banId, userId)) {
                    matchingUsers.add(userId);
                }
            }
            banMatchingUserMap.put(banId, matchingUsers);
        }
        return banMatchingUserMap;
    }

    private void findValidCombinations(Set<String> currentCombination, Map<String, List<String>> banMatchingUserMap, int index, String[] banned_id) {
        if (index == banned_id.length) {
            combinations.add(new HashSet<>(currentCombination));
            return;
        }

        String bannedId = banned_id[index];
        List<String> matchingUsers = banMatchingUserMap.get(bannedId);
        for (String user : matchingUsers) {
            if (!currentCombination.contains(user)) {
                currentCombination.add(user);
                findValidCombinations(currentCombination, banMatchingUserMap, index + 1, banned_id);
                currentCombination.remove(user);
            }
        }
    }

    private boolean isBannedId(String banId, String userId) {
        for (int i = 0; i < banId.length(); i++) {
            char c1 = banId.charAt(i);
            char c2 = userId.charAt(i);
            boolean isCharEquals = c1 == c2 || c1 == '*' || c2 == '*';
            if (!isCharEquals) {
                return false;
            }
        }
        return true;
    }

}
