package org.example.inflearn.chapter01;

import java.util.Arrays;

public class 청소 {

    // 내가 푼방법
    public int[] solution1(int[][] board, int k) {
        int[] answer = new int[2];
        char direction = 'R';
        int length = board.length;

        for (int i = 0; i < k; i++) {

            if (direction == 'R') {
                if (answer[1] + 1 < length && board[answer[0]][answer[1] + 1] != 1) {
                    answer[1]++;
                } else {
                    direction = 'D';
                }
            } else if (direction == 'D') {
                if (answer[0] + 1 < length && board[answer[0] + 1][answer[1]] != 1) {
                    answer[0]++;
                } else {
                    direction = 'L';
                }
            } else if (direction == 'L') {
                if (answer[1] - 1 >= 0 && board[answer[0]][answer[1] - 1] != 1) {
                    answer[1]--;
                } else {
                    direction = 'U';
                }
            } else {
                if (answer[0] - 1 >= 0 && board[answer[0] - 1][answer[1]] != 1) {
                    answer[0]--;
                } else {
                    direction = 'R';
                }
            }
        }
        return answer;
    }

    // 정답
    public int[] solution2(int[][] board, int k) {
        int[] answer = new int[2];
        int n = board.length;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0, d = 1, count = 0;

        while(count < k){
            count++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1){
                d = (d + 1) % 4;
                continue;
            }
            x = nx;
            y = ny;
        }

        answer[0] = x;
        answer[1] = y;
        return answer;
    }

    public int[] solution(int[][] board, int k) {
        int[] answer = new int[2];

        // 북 동 남 서
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0;
        int y = 0;
        int count = 0;
        int d = 1;

        while(count < k) {
            count++;

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board.length || board[nx][ny] == 1) {
                d = (d + 1) % 4;
                continue;
            }

            x = nx;
            y = ny;
        }

        answer[0] = x;
        answer[1] = y;

        return answer;
    }

    public static void main(String[] args) {
        청소 T = new 청소();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}
