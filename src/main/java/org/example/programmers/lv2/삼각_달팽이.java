package org.example.programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 삼각_달팽이 {
    public int[] solution(int n) {
        int[][] triangle = new int[n][];
        // 아래, 오른쪽, 위
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        int dir = 0;

        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
        }
        int count = 1;
        int x = 0;
        int y = 0;

        while (true) {
            if (triangle[x][y] != 0) {
                break;
            }
            triangle[x][y] = count;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= triangle.length || ny >= triangle[x].length || triangle[nx][ny] != 0) {
                dir = (dir + 1) % 3;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;
            count++;
        }

        List<Integer> temp = new ArrayList<>();
        for (int[] tmp : triangle) {
            for (int m : tmp) {
                temp.add(m);
            }
        }

        return temp.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        삼각_달팽이 obj = new 삼각_달팽이();
        System.out.println(Arrays.toString(obj.solution(1)));
    }
}
