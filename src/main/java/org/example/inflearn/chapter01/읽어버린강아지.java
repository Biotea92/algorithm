package org.example.inflearn.chapter01;

import java.util.Arrays;

public class 읽어버린강아지 {

    public int solution(int[][] board){
        int answer = 0;

        int[] human = new int[2];
        int[] dog = new int[2];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 2) {
                    human[0] = i;
                    human[1] = j;
                }
                if (board[i][j] == 3) {
                    dog[0] = i;
                    dog[1] = j;
                }
            }
        }

        // 북 동 남 서
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        int humanD = 0;
        int dogD = 0;

        int humanX = human[1];
        int humanY = human[0];
        int dogX = dog[1];
        int dogY = dog[0];

        while (true) {
            answer++;

            int humanNx = humanX + dx[humanD];
            int humanNy = humanY + dy[humanD];
            int dogNx = dogX + dx[dogD];
            int dogNy = dogY + dy[dogD];

            if (humanNx < 0 || humanNx >= 10 || humanNy < 0 || humanNy >= 10 || board[humanNy][humanNx] == 1) {
                humanD = (humanD + 1) % 4;
            } else {
                humanX = humanNx;
                humanY = humanNy;
            }

            if (dogNx < 0 || dogNx >= 10 || dogNy < 0 || dogNy >= 10 || board[dogNy][dogNx] == 1) {
                dogD = (dogD + 1) % 4;
            } else {
                dogX = dogNx;
                dogY = dogNy;
            }

            if (humanX == dogX && humanY == dogY)
                return answer;
            if (answer >= 10000)
                return 0;
        }
    }

    public static void main(String[] args){
        읽어버린강아지 T = new 읽어버린강아지();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}
