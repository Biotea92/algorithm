package org.example.samsumg;

import java.util.Arrays;

public class 게리멘더링2 {
    /*
        재현시의 시장 구재현은 지난 몇 년간 게리맨더링을 통해서 자신의 당에게 유리하게 선거구를 획정했다.
        견제할 권력이 없어진 구재현은 권력을 매우 부당하게 행사했고, 심지어는 시의 이름도 재현시로 변경했다.
        이번 선거에서는 최대한 공평하게 선거구를 획정하려고 한다.

        재현시는 크기가 N×N인 격자로 나타낼 수 있다. 격자의 각 칸은 구역을 의미하고, r행 c열에 있는 구역은 (r, c)로 나타낼 수 있다.
        구역을 다섯 개의 선거구로 나눠야 하고, 각 구역은 다섯 선거구 중 하나에 포함되어야 한다. 선거구는 구역을 적어도 하나 포함해야 하고,
        한 선거구에 포함되어 있는 구역은 모두 연결되어 있어야 한다. 구역 A에서 인접한 구역을 통해서 구역 B로 갈 수 있을 때,
        두 구역은 연결되어 있다고 한다. 중간에 통하는 인접한 구역은 0개 이상이어야 하고, 모두 같은 선거구에 포함된 구역이어야 한다.

        선거구를 나누는 방법은 다음과 같다.
            1. 기준점 (x, y)와 경계의 길이 d1, d2를 정한다. (d1, d2 ≥ 1, 1 ≤ x < x+d1+d2 ≤ N, 1 ≤ y-d1 < y < y+d2 ≤ N)
            2. 다음 칸은 경계선이다.
                  1. (x, y), (x+1, y-1), ..., (x+d1, y-d1)
                  2. (x, y), (x+1, y+1), ..., (x+d2, y+d2)
                  3. (x+d1, y-d1), (x+d1+1, y-d1+1), ..., (x+d1+d2, y-d1+d2)
                  4. (x+d2, y+d2), (x+d2-1, y+d2+1), ..., (x+d2+d1, y+d2-d1)
            3. 경계선과 경계선의 안에 포함되어있는 5번 선거구이다.
            4. 5번 선거구에 포함되지 않은 구역 (r, c)의 선거구 번호는 다음 기준을 따른다.
                  1. 1번 선거구: 1 ≤ r < x+d1, 1 ≤ c ≤ y
                  2. 2번 선거구: 1 ≤ r ≤ x+d2, y < c ≤ N
                  3. 3번 선거구: x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
                  4. 4번 선거구: x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N

        (구역의 번호는 r행 c열에 있는 구역의 번호를 의미하고, (r, c)는 r행 c열에 있는 구역을 의미한다.)
    */
    private static final int BORDER = 5;

    public int solution(int n, int[][] population) {
        // 1. 구역 나누기 (관건)
        //     - 경계선
        //     - 선거구 나누기
        // 2. 각 구역의 인구수 합 구하기
        // 3. 인구수 최대 구역 최소 구역 차이 구하기
        // 4. 최소값 구하기

        int min = Integer.MAX_VALUE;

        // total population
        int totalPopulation = 0;
        for (int[] arr : population) {
            for (int areaPopulation : arr) {
                totalPopulation += areaPopulation;
            }
        }

        // x < x + d1 + d2 < n
        // 0 <= y - d1 < y < y + d2 < n
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                for (int d1 = 1; d1 < n; d1++) {
                    for (int d2 = 1; d2 < n; d2++) {

                        if (x + d1 + d2 >= n || y - d1 < 0 || y + d2 >= n)
                            continue;

                        int[][] map = new int[n][n];
                        int[] peopleCountPerWard = new int[6];

                        // 경계선
                        for (int i = 0; i <= d1; i++) {
                            map[x + i][y - i] = BORDER;
                            map[x + d2 + i][y + d2 - i] = BORDER;
                        }

                        for (int i = 0; i <= d2; i++) {
                            map[x + i][y + i] = BORDER;
                            map[x + d1 + i][y - d1 + i] = BORDER;
                        }

                        // 1. 1번 선거구: 1 ≤ r < x+d1, 1 ≤ c ≤ y
                        // 2. 2번 선거구: 1 ≤ r ≤ x+d2, y < c ≤ N
                        // 3. 3번 선거구: x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
                        // 4. 4번 선거구: x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N

                        // 1구역
                        for (int i = 0; i < x + d1; i++) {
                            for (int j = 0; j <= y; j++) {
                                if (map[i][j] == BORDER) break;
                                peopleCountPerWard[1] += population[i][j];
                            }
                        }

                        // 2구역
                        for (int i = 0; i <= x + d2; i++) {
                            for (int j = n - 1; j > y; j--) {
                                if (map[i][j] == BORDER) break;
                                peopleCountPerWard[2] += population[i][j];
                            }
                        }

                        // 3구역
                        for (int i = x + d1; i < n; i++) {
                            for (int j = 0; j < y - d1 + d2; j++) {
                                if (map[i][j] == BORDER) break;
                                peopleCountPerWard[3] += population[i][j];
                            }
                        }

                        // 4구역
                        for (int i = x + d2 + 1; i < n; i++) {
                            for (int j = n - 1; j >= y - d1 + d2; j--) {
                                if (map[i][j] == BORDER) break;
                                peopleCountPerWard[4] += population[i][j];
                            }
                        }

                        // 5구역
                        peopleCountPerWard[5] = totalPopulation;
                        for (int i = 1; i < 5; i++) {
                            peopleCountPerWard[5] -= peopleCountPerWard[i];
                        }

                        Arrays.sort(peopleCountPerWard);
                        min = Math.min(min, peopleCountPerWard[5] - peopleCountPerWard[1]);
                    }
                }
            }
        }
        return min;
    }

    private void printXYD(int x, int y, int d1, int d2) {
        System.out.println("x = " + x + ", y = " + y + ", d1 = " + d1 + ", d2 = " + d2);
    }

    private void print(int x, int y, int d1, int d2, int[][] map) {
        printXYD(x, y, d1, d2);
        printMap(map);
    }

    private void printMap(int[][] map) {
        System.out.println();
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println("====================================");
    }
}
