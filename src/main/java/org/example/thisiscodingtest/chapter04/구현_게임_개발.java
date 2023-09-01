package org.example.thisiscodingtest.chapter04;

public class 구현_게임_개발 {

    public int solution(int[] map, int[] characterLocation, int[]... arrays) {
        // 북쪽 -> 남쪽 이동 
        // 서쪽 -> 동쪽 이동
        // 남쪽 -> 북쪽 이동
        // 동쪽 -> 서쪽 이동

        int[][] newMap = arrays;
        boolean[][] isLanded = new boolean[newMap.length][newMap.length];
        for (int i = 0; i < isLanded.length; i++) {
            for (int j = 0; j < isLanded[0].length; j++) {
                isLanded[i][j] = false;
            }
        }

        int count = 0;
        int location = 0;
        System.out.println("newMap[1][1] = " + newMap[1][1]);
        System.out.println("newMap[2][1] = " + newMap[2][1]);
        System.out.println("newMap[1][2] = " + newMap[1][2]);
        System.out.println("newMap[2][2] = " + newMap[2][2]);

        characterLocation[0]--;
        characterLocation[1]--;

        isLanded[characterLocation[0]][characterLocation[1]] = true;

        while (true) {
            try {
                switch (characterLocation[2]) {
                    case 0:
                        location = newMap[characterLocation[0] + 1] [characterLocation[1]];
                        if (location == 0 || isLanded[characterLocation[0] + 1] [characterLocation[1]]) {
                            characterLocation[1]++;
                        }
                        else if (location != 0) {
                            characterLocation[0]++;
                        }
                        count++;
                        characterLocation[2] = 3;
                        break;
                    case 1:
                        location = newMap[characterLocation[0]] [characterLocation[1] - 1];
                        if (location == 0 || isLanded[characterLocation[0]] [characterLocation[1] - 1]) {
                            characterLocation[0]++;
                        }
                        else if (location != 0) {
                            characterLocation[1]--;
                        }
                        count++;
                        characterLocation[2]--;
                        break;
                    case 2:
                        location = newMap[characterLocation[0] - 1] [characterLocation[1]];
                        if (location == 0 || isLanded[characterLocation[0] - 1] [characterLocation[1]]) {
                            characterLocation[1]--;
                        }
                        else if (location != 0) {
                            characterLocation[0]--;
                        }
                        count++;
                        characterLocation[2]--;
                        break;
                    case 3:
                        location = newMap[characterLocation[0]] [characterLocation[1] + 1];
                        if (location == 0 || isLanded[characterLocation[0]] [characterLocation[1] + 1]) {
                            characterLocation[0]--;
                        } else if (location != 0) {
                            characterLocation[1]++;
                        }
                        count++;
                        characterLocation[2]--;
                        break;
                }

                System.out.println("characterLocation[0] = " + characterLocation[0]);
                System.out.println("characterLocation[1] = " + characterLocation[1]);
                System.out.println("characterLocation[2] = " + characterLocation[2]);
                System.out.println("location = " + location);
                System.out.println("================================================");
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                System.out.println("exception = ");
                break;
            }
        }

        return count;
    }
}
