package org.example.inflearn.chapter02;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class 문서_도난 {
    public String[] solution1(String[] reports, String times){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        Map<String, LocalTime> map = new HashMap<>();

        for (String report : reports) {
            String name = report.split(" ")[0];
            LocalTime time = LocalTime.parse(report.split(" ")[1], formatter);
            map.put(name, time);
        }

        List<Map.Entry<String, LocalTime>> collect = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());

        LocalTime parsedStartTime = LocalTime.parse(times.split(" ")[0], formatter);
        LocalTime parsedEndTime = LocalTime.parse(times.split(" ")[1], formatter);

        List<String> tmp = new ArrayList<>();

        for (Map.Entry<String, LocalTime> stringLocalTimeEntry : collect) {
            LocalTime value = stringLocalTimeEntry.getValue();

            if (value.isBefore(parsedEndTime) && value.isAfter(parsedStartTime))
                tmp.add(stringLocalTimeEntry.getKey());

            if (value.equals(parsedEndTime) || value.equals(parsedStartTime))
                tmp.add(stringLocalTimeEntry.getKey());
        }

//        for (String s : map.keySet()) {
//            if (map.get(s).isBefore(parsedEndTime) && map.get(s).isAfter(parsedStartTime)) {
//                tmp.add(s);
//            }
//            if (map.get(s).equals(parsedEndTime) || map.get(s).equals(parsedStartTime)) {
//                tmp.add(s);
//            }
//        }

        return tmp.toArray(new String[0]);
    }

    static class Info implements Comparable<Info> {
        private String name;
        private int time;

        public Info(String name, int time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public int compareTo(Info o) {
            return this.time - o.time;
        }

        public String getName() {
            return name;
        }

        public int getTime() {
            return time;
        }
    }

    public String[] solution(String[] reports, String times){
        ArrayList<Info> tmp = new ArrayList<>();
        for (String report : reports) {
            String name = report.split(" ")[0];
            int time = getTime(report.split(" ")[1]);
            tmp.add(new Info(name, time));
        }

        Collections.sort(tmp);

        String[] time = times.split(" ");
        int startTime = getTime(time[0]);
        int endTime = getTime(time[1]);

        List<String> res = new ArrayList<>();
        for (Info info : tmp) {
            if (info.getTime() >= startTime && info.getTime() <= endTime) {
                res.add(info.getName());
            }
            if (info.getTime() > endTime) {
                break;
            }
        }

        return res.toArray(new String[0]);
    }

    public int getTime(String time) {
        return Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
    }

    public static void main(String[] args){
        문서_도난 T = new 문서_도난();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}
