package org.example.programmers.lv2;

import java.util.*;

public class 순위_검색 {

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        Arrays.sort(info, (a, b) -> {
            int aScore = Integer.parseInt(a.split(" ")[4]);
            int bScore = Integer.parseInt(b.split(" ")[4]);
            return aScore - bScore;
        });
        List<List<String>> infoList = new ArrayList<>(info.length);
        for (String s : info) {
            String[] ss = s.split(" ");
            infoList.add(List.of(ss[0], ss[1], ss[2], ss[3], ss[4]));
        }
        for (int i = 0; i < query.length; i++) {
            String s = query[i];
            String[] tmp = s.split(" and ");
            String language = tmp[0];
            String position = tmp[1];
            String grade = tmp[2];
            String[] tmp2 = tmp[3].split(" ");
            String food = tmp2[0];
            int score = Integer.parseInt(tmp2[1]);

            int result = 0;
            for (List<String> infos : infoList) {
                if (language.equals("-") || language.equals(infos.get(0))) {
                    if (position.equals("-") || position.equals(infos.get(1))) {
                        if (grade.equals("-") || grade.equals(infos.get(2))) {
                            if (food.equals("-") || food.equals(infos.get(3))) {
                                if (Integer.parseInt(infos.get(4)) >= score) {
                                    result++;
                                }
                            }
                        }
                    }
                }
            }
            answer[i] = result;
        }
        return answer;
    }
}
