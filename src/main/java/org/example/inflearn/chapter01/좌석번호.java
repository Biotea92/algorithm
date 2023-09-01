package org.example.inflearn.chapter01;

import java.util.Arrays;

public class 좌석번호 {

    public int[] solution(int c, int r, int k) {
        int[] answer = new int[2];
        if (c * r < k) {
            return answer;
        }

        int[][] board = new int[c][r];

        // 북 동 남 서
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int x = 0, y = 0, d = 1, count = 1;

        while (count < k) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= c || ny >= r || board[nx][ny] > 0) {
                d = (d+1)%4;
                continue;
            }
            board[x][y] = count;
            count++;
            x = nx;
            y = ny;
        }

        answer[0] = x + 1;
        answer[1] = y + 1;
        return answer;
    }

    public static void main(String[] args) {
        좌석번호 T = new 좌석번호();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}
