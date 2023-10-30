package org.example.programmers.lv2;

public class 쿼드압축_후_개수_세기 {

    private final int[] answer = new int[2];
    private final int ZERO = 0;
    private final int ONE = 1;

    public int[] solution(int[][] arr) {
        dfs(arr);
        return answer;
    }

    public void dfs(int[][] arr) {
        int length = arr.length;
        if (length == 1) {
            answer[arr[0][0]] += 1;
            return;
        }
        int divideLength = length / 2;
        int checkNum = -1;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int num = arr[i][j];
                if (i == 0 && j == 0) {
                    checkNum = num;
                } else {
                    if (checkNum != num) {
                        // 4등분 해서 dfs
                        int[][] a = new int[divideLength][divideLength];
                        int[][] b = new int[divideLength][divideLength];
                        int[][] c = new int[divideLength][divideLength];
                        int[][] d = new int[divideLength][divideLength];

                        for (int k = 0; k < divideLength; k++) {
                            for (int l = 0; l < divideLength; l++) {
                                a[k][l] = arr[k][l];
                            }
                        }

                        for (int k = 0; k < divideLength; k++) {
                            for (int l = divideLength; l < length; l++) {
                                b[k][l - divideLength] = arr[k][l];
                            }
                        }

                        for (int k = divideLength; k < length; k++) {
                            for (int l = 0; l < divideLength; l++) {
                                c[k - divideLength][l] = arr[k][l];
                            }
                        }

                        for (int k = divideLength; k < length; k++) {
                            for (int l = divideLength; l < length; l++) {
                                d[k - divideLength][l - divideLength] = arr[k][l];
                            }
                        }

                        dfs(a);
                        dfs(b);
                        dfs(c);
                        dfs(d);

                        return;
                    }
                }
            }
        }

        answer[checkNum] += 1;
    }
}
