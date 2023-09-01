package org.example.inflearn.chapter02;

import java.util.*;

public class 회장_선거 {

    public String solution1(String[] votes, int k){
        Map<String, Integer> votedCountMap = new HashMap<>();
        for (String vote: votes) {
            String[] votePerson = vote.split(" ");
            votedCountMap.put(votePerson[1], votedCountMap.getOrDefault(votePerson[1], 0) + 1);
        }

        List<String> overKVoted = new ArrayList<>();
        for (String s : votedCountMap.keySet()) {
            if (votedCountMap.get(s) >= k) {
                overKVoted.add(s);
            }
        }

        Map<String, Integer> giftCount = new HashMap<>();
        for (String vote: votes) {
            String[] votePerson = vote.split(" ");
            if (overKVoted.contains(votePerson[1])) {
                giftCount.put(votePerson[0], giftCount.getOrDefault(votePerson[0], 0) + 1);
            }
        }

        int maxCount = 0;
        List<String> tmp = new ArrayList<>();
        for (String s : giftCount.keySet()) {
            if (maxCount < giftCount.get(s)) {
                tmp.clear();
            }
            maxCount = Math.max(maxCount, giftCount.get(s));

            if (giftCount.get(s) == maxCount) {
                tmp.add(s);
            }
        }
        Collections.sort(tmp);
        return tmp.get(0);
    }

    public String solution(String[] votes, int k){
        HashMap<String, Set<String>> voteHash = new HashMap<>();
        HashMap<String, Integer> candidate = new HashMap<>();

        for (String vote : votes) {
            String[] persons = vote.split(" ");
            String recommendedPerson = persons[0];
            String votedPerson = persons[1];

            voteHash.putIfAbsent(recommendedPerson, new HashSet<>());
            voteHash.get(recommendedPerson).add(votedPerson);
            candidate.put(votedPerson, candidate.getOrDefault(votedPerson, 0) + 1);
        }

        Map<String, Integer> present = new HashMap<>();
        for (String s : voteHash.keySet()) {
            for (String s1 : voteHash.get(s)) {
                if (candidate.get(s1) >= k) {
                    present.put(s, present.getOrDefault(s, 0) + 1);
                }
            }
        }

        int maxCount = 0;
        List<String> tmp = new ArrayList<>();
        for (String s : present.keySet()) {
            if (maxCount < present.get(s)) {
                tmp.clear();
            }
            maxCount = Math.max(maxCount, present.get(s));

            if (present.get(s) == maxCount) {
                tmp.add(s);
            }
        }

        tmp.sort(Comparator.naturalOrder());
        return tmp.get(0);
    }

    public String solution2(String[] votes, int k){
        String answer = " ";
        HashMap<String, HashSet<String>> voteHash = new HashMap<>();
        HashMap<String, Integer> candidate = new HashMap<>();
        HashMap<String, Integer> present = new HashMap<>();
        for(String x : votes){
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            voteHash.putIfAbsent(a, new HashSet<String>());
            voteHash.get(a).add(b);
            candidate.put(b, candidate.getOrDefault(b, 0) + 1);
        }
        int max=Integer.MIN_VALUE;
        for(String a : voteHash.keySet()){
            int cnt = 0;
            for(String b : voteHash.get(a)){
                if(candidate.get(b) >= k) cnt++;
            }
            present.put(a, cnt);
            max = Math.max(max, cnt);
        }
        ArrayList<String> tmp = new ArrayList<>();
        for(String name : present.keySet()){
            if(present.get(name) == max) tmp.add(name);
        }
        tmp.sort((a, b) -> a.compareTo(b));
        answer = tmp.get(0);
        return answer;
    }

    public static void main(String[] args){
        회장_선거 T = new 회장_선거();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}
