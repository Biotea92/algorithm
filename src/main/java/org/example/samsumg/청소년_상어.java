package org.example.samsumg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 청소년_상어 {

    private static final int EATEN_FISH_CHECK_NUMBER = -1;
    private static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static final int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    public int solution(int[][] map) {
        maxSum = 0;
        int[][] fish = new int[4][4];
        int[][] fishDirection = new int[4][4];
        Map<Integer, List<Integer>> numberOfFishMap = new HashMap<>();

        for (int i = 0; i < map.length; i++) {
            int index = -1;
            for (int j = 0; j < map[i].length; j++) {
                if (j % 2 == 0) {
                    index++;
                    fish[i][index] = map[i][j];
                    numberOfFishMap.put(map[i][j], List.of(i, index));
                } else {
                    fishDirection[i][index] = map[i][j] - 1;
                }
            }
        }

        // 초기에 상어가 물고기를 먹을때
        int sharkDirection = fishDirection[0][0];
        List<Integer> sharkPosition = List.of(0, 0);
        int eatenFishOfShark = fish[0][0];

        numberOfFishMap.remove(fish[0][0]);
        fish[0][0] = EATEN_FISH_CHECK_NUMBER;
        fishDirection[0][0] = EATEN_FISH_CHECK_NUMBER;

        dfs(fish, fishDirection, numberOfFishMap, sharkDirection, sharkPosition, eatenFishOfShark);

        return maxSum;
    }

    private static int maxSum = 0;

    private void dfs(int[][] fish, int[][] fishDirection, Map<Integer, List<Integer>> numberOfFishMap,
                     int sharkDirection, List<Integer> sharkPosition, int eatenFishOfShark) {
        maxSum = Math.max(maxSum, eatenFishOfShark);
        moveFishes(numberOfFishMap, fishDirection, fish, sharkPosition);

        for (int i = 1; i < 4; i++) {
            int x = sharkPosition.get(0);
            int y = sharkPosition.get(1);

            int nx = x + dx[sharkDirection] * i;
            int ny = y + dy[sharkDirection] * i;

            if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || fish[nx][ny] == EATEN_FISH_CHECK_NUMBER) {
                continue;
            }

            int[][] tempFish = new int[4][4];
            int[][] tempFishDirection = new int[4][4];

            for (int j = 0; j < tempFish.length; j++) {
                for (int k = 0; k < tempFish[i].length; k++) {
                    tempFish[j][k] = fish[j][k];
                    tempFishDirection[j][k] = fishDirection[j][k];
                }
            }

            Map<Integer, List<Integer>> tempNumberOfFishMap = new HashMap<>(numberOfFishMap);

            // 상어 먹방
            int tempEatenFishOfShark = tempFish[nx][ny];
            tempFish[nx][ny] = EATEN_FISH_CHECK_NUMBER;
            int tempSharkDirection = tempFishDirection[nx][ny];
            tempFishDirection[nx][ny] = EATEN_FISH_CHECK_NUMBER;

            tempNumberOfFishMap.remove(tempEatenFishOfShark);
            List<Integer> tempSharkPosition = List.of(nx, ny);

            dfs(tempFish, tempFishDirection, tempNumberOfFishMap, tempSharkDirection, tempSharkPosition, tempEatenFishOfShark + eatenFishOfShark);
        }
    }

    private void moveFishes(Map<Integer, List<Integer>> numberOfFish, int[][] fishDir, int[][] fish, List<Integer> sharkPosition) {
        for (int i = 1; i <= 16; i++) {
            List<Integer> fishWhere = numberOfFish.get(i);
            if (fishWhere != null) {
                int x = fishWhere.get(0);
                int y = fishWhere.get(1);
                int dir = fishDir[x][y];

                if (dir == EATEN_FISH_CHECK_NUMBER) {
                    continue;
                }

                for (int j = 0; j < 8; j++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || (nx == sharkPosition.get(0) && ny == sharkPosition.get(1))) {
                        dir = (dir + 1) % 8;
                        continue;
                    }

                    int tempFish = fish[x][y];

                    fish[x][y] = fish[nx][ny];
                    fishDir[x][y] = fishDir[nx][ny];

                    fish[nx][ny] = tempFish;
                    fishDir[nx][ny] = dir;

                    numberOfFish.put(fish[nx][ny], List.of(nx, ny));
                    numberOfFish.put(fish[x][y], List.of(x, y));

                    break;
                }
            }
        }
    }

//    private void print(int[][] fish, int[][] fishDir, Map<Integer, List<Integer>> numberOfFish, int sharkDir, List<Integer> sharkPosition, int eatenFishOfShark) {
//        System.out.println();
//        System.out.println("fish");
//        for (int[] ints : fish) {
//            for (int anInt : ints) {
//                System.out.print(anInt + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();
//
//        System.out.println("fishDir");
//        for (int[] ints : fishDir) {
//            for (int anInt : ints) {
//                System.out.print(anInt + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();
//        System.out.println("numberOfFish = " + numberOfFish);
//        System.out.println("sharkDir = " + sharkDir);
//        System.out.println("sharkPosition = " + sharkPosition);
//        System.out.println("eatenFishOfShark = " + eatenFishOfShark);
//        System.out.println("======================================");
//    }
}
