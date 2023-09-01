package org.example.programmers.lv1;

import java.util.*;
import java.util.stream.Collectors;

public class 신고_결과_받기 {

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        int[] ints = solution2(id_list, report, k);

        for (int anInt : ints) {
            System.out.println(anInt);
        }
//        System.out.println(ints[0]==2);
//        System.out.println(ints[1]==1);
//        System.out.println(ints[2]==1);
//        System.out.println(ints[3]==0);
        // 결과 ints = {2,1,1,0}
    }

    // 신고 결과 받기 https://school.programmers.co.kr/learn/courses/30/lessons/92334?language=java
    public static int[] solution1(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> result = new HashMap<>();
        for (String id : id_list) {
            Set<String> myReport = new HashSet<>();
            for (String reportHistory : report) {
                String[] reportSplit = reportHistory.split(" ");
                if (id.equals(reportSplit[0])) {
                    myReport.add(reportSplit[1]);
                }
            }
            result.put(id, myReport);
        }

        System.out.println("result = " + result);

        Map<String, Integer> reportCount = new HashMap<>();
        for (String value : id_list) {
            for (String s : result.get(value)) {
                reportCount.put(s, reportCount.getOrDefault(s, 0) + 1);
            }
        }

        System.out.println("reportCount = " + reportCount);

        Map<String, Integer> lastResult = new HashMap<>();
        for (String s : id_list) {
            if (reportCount.getOrDefault(s, 0) >= k) {
                for (String id : result.keySet()) {
                    if (result.get(id).contains(s)) {
                        lastResult.put(id, lastResult.getOrDefault(id, 0) + 1);
                    }
                }
            }
        }

        System.out.println("lastResult = " + lastResult);

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = lastResult.getOrDefault(id_list[i], 0);
        }
        return answer;
    }

    // 신고 결과 받기 솔루션 2
    public static int[] solution2(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> reporterInfoMap = new HashMap<>();
        Map<String, Integer> reportedCountInfoMap = new HashMap<>();

        for (String reportInfo : report) {
            String[] split = reportInfo.split(" ");
            String reporter = split[0];
            String reported = split[1];

            boolean isReporterReportedTwice = reporterInfoMap.getOrDefault(reporter, Set.of()).contains(reported);

            if (reporterInfoMap.containsKey(reporter)) {
                reporterInfoMap.get(reporter).add(reported);
            } else {
                HashSet<String> setOfReported = new HashSet<>();
                setOfReported.add(reported);
                reporterInfoMap.put(reporter, setOfReported);
            }
            
            if (!isReporterReportedTwice) {
                reportedCountInfoMap.put(reported, reportedCountInfoMap.getOrDefault(reported, 0) + 1);
            }
        }

        Map<String, Integer> result = new HashMap<>();
        for (String s : id_list) {
            if (reportedCountInfoMap.getOrDefault(s, 0) >= k) {
                for (String id : reporterInfoMap.keySet()) {
                    if (reporterInfoMap.getOrDefault(id, Set.of()).contains(s)) {
                        result.put(id, result.getOrDefault(id, 0) + 1);
                    }
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = result.getOrDefault(id_list[i], 0);
        }
        return answer;
    }

    // 미친 사람의 솔루션 또라이급
    public int[] solution(String[] id_list, String[] report, int k) {
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        HashMap<String, Integer> count = new HashMap<>();
        for (String s : list) {
            String target = s.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        return Arrays.stream(id_list).map(_user -> {
            final String user = _user;
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
            return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
        }).mapToInt(Long::intValue).toArray();
    }
}
