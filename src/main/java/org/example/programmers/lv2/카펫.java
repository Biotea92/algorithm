package org.example.programmers.lv2;

public class 카펫 {

    public int[] solution(int brown, int yellow) {
        // 가로의 길이 > 세로의 길이
        // 가로의 길이와 세로의 길이는 최소 3일 것이다 중간에 노랑이 들어가야 되기 때문
        int sum = brown + yellow;
        int x = 3;
        int y = 3;

        while (true) {
            if (sum % x == 0) {
                y = sum / x;
                if (x >= y && (x - 2) * (y - 2) == yellow) {
                    break;
                }
            }
            x++;
        }
        return new int[]{x, y};
    }
}
