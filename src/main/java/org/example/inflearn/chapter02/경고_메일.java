package org.example.inflearn.chapter02;

import java.util.*;

public class 경고_메일 {

    public String[] solution(String[] reports, int time){
        Map<String, Integer> inMap = new HashMap<>();
        Map<String, Integer> sumMap = new HashMap<>();

        for (String report : reports) {
            String name = report.split(" ")[0];
            int timeX = getTime(report.split(" ")[1]);
            String inOrOut = report.split(" ")[2];

            if (inOrOut.equals("in"))
                inMap.put(name, timeX);
            else
                sumMap.put(name, sumMap.getOrDefault(name, 0) + timeX - inMap.get(name));
        }

        List<String> tmp = new ArrayList<>();

        for (String s : sumMap.keySet()) {
            if (sumMap.get(s) > time)
                tmp.add(s);
        }

        tmp.sort(Comparator.naturalOrder());

        return tmp.toArray(new String[0]);
    }

    private int getTime(String time) {
        int HH = Integer.parseInt(time.split(":")[0]);
        int mm = Integer.parseInt(time.split(":")[1]);
        return HH * 60 + mm;
    }

    public static void main(String[] args){
        경고_메일 T = new 경고_메일();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}
