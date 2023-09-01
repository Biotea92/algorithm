package org.example.samsumg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 연구소 {

    /*
#문제
    인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출되었다. 다행히 바이러스는 아직 퍼지지 않았고, 바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 한다.
    연구소는 크기가 N×M인 직사각형으로 나타낼 수 있으며, 직사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다.
    일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.
    예를 들어, 아래와 같이 연구소가 생긴 경우를 살펴보자.

    2 0 0 0 1 1 0
    0 0 1 0 1 2 0
    0 1 1 0 1 0 0
    0 1 0 0 0 0 0
    0 0 0 0 0 1 1
    0 1 0 0 0 0 0
    0 1 0 0 0 0 0

    이때, 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳이다. 아무런 벽을 세우지 않는다면, 바이러스는 모든 빈 칸으로 퍼져나갈 수 있다.
    2행 1열, 1행 2열, 4행 6열에 벽을 세운다면 지도의 모양은 아래와 같아지게 된다.

    2 1 0 0 1 1 0
    1 0 1 0 1 2 0
    0 1 1 0 1 0 0
    0 1 0 0 0 1 0
    0 0 0 0 0 1 1
    0 1 0 0 0 0 0
    0 1 0 0 0 0 0

    바이러스가 퍼진 뒤의 모습은 아래와 같아진다.

    2 1 0 0 1 1 2
    1 0 1 0 1 2 2
    0 1 1 0 1 2 2
    0 1 0 0 0 1 2
    0 0 0 0 0 1 1
    0 1 0 0 0 0 0
    0 1 0 0 0 0 0

    벽을 3개 세운 뒤, 바이러스가 퍼질 수 없는 곳을 안전 영역이라고 한다. 위의 지도에서 안전 영역의 크기는 27이다.
    연구소의 지도가 주어졌을 때 얻을 수 있는 안전 영역 크기의 최댓값을 구하는 프로그램을 작성하시오.

# 입력
    첫째 줄에 지도의 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 8)
    둘째 줄부터 N개의 줄에 지도의 모양이 주어진다. 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 위치이다. 2의 개수는 2보다 크거나 같고, 10보다 작거나 같은 자연수이다.
    빈 칸의 개수는 3개 이상이다.

# 출력
    첫째 줄에 얻을 수 있는 안전 영역의 최대 크기를 출력한다.
     */
    private static final int SAFE_ZONE = 0;
    private static final int WALL = 1;
    private static final int VIRUS = 2;

    public int solution(int N, int M, int[][] mapShape) {
        // 1. 3개의 벽을 세운다.
        // 2. 바이러스가 퍼진다.
        // 3. 안전영역의 크기를 구한다.
        // 4. 1~3을 반복하면서 안전영역의 최대 크기를 구한다.
        int maxArea = Integer.MIN_VALUE;

        List<List<Integer>> safePositions = new ArrayList<>();
        List<List<Integer>> virusPositions = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (mapShape[i][j] == SAFE_ZONE) {
                    safePositions.add(List.of(i, j));
                }
                if (mapShape[i][j] == VIRUS) {
                    virusPositions.add(List.of(i, j));
                }
            }
        }

        // area0에서 세개를 고른다.(벽을 세우는 모든 경우의 수) 조합 알고리즘
        List<List<Integer>> combList = new ArrayList<>();
        boolean[] combinationVisited = new boolean[safePositions.size()];
        getCombination(combList, combinationVisited, 0, safePositions.size(), 3);

        for (List<Integer> combination : combList) {
            // mapShape복사
            int[][] mapShapeCopy = new int[N][];
            for (int i = 0; i < N; i++) {
                mapShapeCopy[i] = Arrays.copyOf(mapShape[i], M);
            }

            // 벽을 세운다.
            for (Integer index : combination) {
                List<Integer> area0Index = safePositions.get(index);
                mapShapeCopy[area0Index.get(0)][area0Index.get(1)] = WALL;
            }

            boolean[][] visited = new boolean[N][M];

            // 바이러스가 퍼진다.
            for (List<Integer> virusPosition : virusPositions) {
                spreadVirus(mapShapeCopy, virusPosition.get(0), virusPosition.get(1), visited);
            }

            // 안전영역의 크기를 구한다.
            int count = 0;
            for (int[] x : mapShapeCopy) {
                for (int y : x) {
                    count += y == SAFE_ZONE ? 1 : 0;
                }
            }

            // 최대값 구하기
            maxArea = Math.max(maxArea, count);
        }

        return maxArea;
    }

    private void spreadVirus(int[][] mapShapeCopy, int x, int y, boolean[][] visited) {
        if (x < 0 || x >= mapShapeCopy.length || y < 0 || y >= mapShapeCopy[0].length || visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        if (mapShapeCopy[x][y] == WALL) {
            return;
        }
        mapShapeCopy[x][y] = VIRUS;
        spreadVirus(mapShapeCopy, x - 1, y, visited);
        spreadVirus(mapShapeCopy, x + 1, y, visited);
        spreadVirus(mapShapeCopy, x, y - 1, visited);
        spreadVirus(mapShapeCopy, x, y + 1, visited);
    }

    private void getCombination(List<List<Integer>> combList, boolean[] combinationVisited, int start, int n, int r) {
        if (r == 0) {
            addCombination(combList, combinationVisited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            combinationVisited[i] = true;
            getCombination(combList, combinationVisited, i + 1, n, r - 1);
            combinationVisited[i] = false;
        }
    }

    private void addCombination(List<List<Integer>> combList, boolean[] visited, int n) {
        List<Integer> tmp = new ArrayList<>(3);
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                tmp.add(i);
            }
        }
        combList.add(tmp);
    }
}
