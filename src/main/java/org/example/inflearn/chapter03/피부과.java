package org.example.inflearn.chapter03;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 피부과 {

    static class Info {
        public int time;
        public int laserType;

        public Info(int time, int laserType) {
            this.time = time;
            this.laserType =laserType;
        }
    }

    public int solution(int[] laser, String[] enter) {
        int answer = 0;

        List<Info> infos = new ArrayList<>(enter.length);
        for (String s : enter) {
            int time = getTime(s.split(" ")[0]);
            int laserType = Integer.parseInt(s.split(" ")[1]);
            infos.add(new Info(time, laserType));
        }

        Deque<Integer> q = new LinkedList<>();
        q.offer(infos.get(0).laserType);

        int endTime = infos.get(0).time;
        int pos = 1;

        for (int i = endTime; i <= 60 * 20; i++) {

            if (pos < infos.size() && i == infos.get(pos).time) {
                if (q.isEmpty() && i > endTime) {
                    endTime = i;
                }
                q.offer(infos.get(pos).laserType);
                pos++;
            }

            if (i == endTime && !q.isEmpty()) {
                int idx = q.poll();
                endTime += laser[idx];
            }


            answer = Math.max(answer, q.size());
        }

        return answer;
    }

    public int getTime(String time) {
        int HH = Integer.parseInt(time.split(":")[0]);
        int mm = Integer.parseInt(time.split(":")[1]);
        return HH * 60 + mm;
    }

    public static void main(String[] args) {
        피부과 T = new 피부과();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}
