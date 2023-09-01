package org.example.inflearn.chapter01;

import java.util.Arrays;

public class 비밀번호 {

    // 내가 푼 방법 강사의 밑의 방법이 더 좋은듯
    public int solution(int[] keypad, String password){
        int answer = 0;

        int[][] keypadXY = new int[3][3];
        for (int i = 0; i < 3; i++) {
            keypadXY[0][i] = keypad[i];
            keypadXY[1][i] = keypad[i+3];
            keypadXY[2][i] = keypad[i+6];
        }

        String[] chars = password.split("");

        for (int i = 1; i < chars.length; i++) {
            int preNum = Integer.parseInt(chars[i-1]);
            int curNum = Integer.parseInt(chars[i]);

            int[] preNumIndex = new int[2];
            int[] curNumIndex = new int[2];

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (keypadXY[j][k] == preNum) {
                        preNumIndex[0] = j;
                        preNumIndex[1] = k;
                    }
                    if (keypadXY[j][k] == curNum) {
                        curNumIndex[0] = j;
                        curNumIndex[1] = k;
                    }
                }
            }

            if (preNumIndex[0] + 2 == curNumIndex[0] || preNumIndex[0] - 2 == curNumIndex[0]
                    || preNumIndex[1] + 2 == curNumIndex[1] || preNumIndex[1] - 2 == curNumIndex[1]) {
                answer += 2;
            } else if (preNumIndex[0] == curNumIndex[0] && preNumIndex[1] == curNumIndex[1]) {

            } else {
                answer++;
            }
        }
        return answer;
    }

    public int solution1(int[] keypad, String password){
        int answer = 0;

        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        int[][] pad = new int[3][3];
        int[][] dist = new int[10][10];

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                pad[i][j] = keypad[i*3 + j];
            }
        }

        for(int i = 0; i < 10; i++){
            Arrays.fill(dist[i], 2);
        }

        for(int i = 0; i < 10; i++)
            dist[i][i] = 0;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int from = pad[i][j];
                for(int k = 0; k < 8; k++){
                    if(i+dx[k] >= 0 && i+dx[k] < 3 && j+dy[k] >= 0 && j+dy[k] < 3){
                        int to = pad[i+dx[k]][j+dy[k]];
                        dist[from][to] = 1;
                    }
                }
            }
        }

        for(int i = 1; i < password.length(); i++){
            int from = (int)password.charAt(i-1)-48;
            int to = (int)password.charAt(i)-48;
            answer += dist[from][to];
        }

        return answer;
    }

    public static void main(String[] args){
        비밀번호 T = new 비밀번호();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}
