package org.example.programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;

public class 거리두기_확인하기 {

    // 위 오른쪽 아래 왼쪽
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];

            String[][] room = new String[5][];
            for (int j = 0; j < place.length; j++) {
                room[j] = place[j].split("");
            }

            if (isDistanced(room)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }

    private boolean isDistanced(String[][] room) {
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                if (!room[i][j].equals("P"))
                    continue;
                if (!isDistanced(room, i, j))
                    return false;
            }
        }
        return true;
    }

    private boolean isDistanced(String[][] room, int x, int y) {
        for (int d = 0; d < dx.length; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5)
                continue;
            switch (room[nx][ny]) {
                case "P":
                    return false;
                case "O":
                    if (isNextToVolunteer(room, nx, ny, (d + 2) % 4))
                        return false;
                    break;
            }
        }
        return true;
    }

    private boolean isNextToVolunteer(String[][] room, int x, int y, int exclude) {
        for (int d = 0; d < 4; d++) {
            if (d == exclude)
                continue;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5)
                continue;
            if (room[nx][ny].equals("P"))
                return true;
        }
        return false;
    }
}
