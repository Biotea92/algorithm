package org.example.thisiscodingtest.chapter04;

import java.util.Arrays;
import java.util.List;

public class 구현_왕실의_나이트 {

    public int solution(String location) {
        String[] split = location.split("");
        String columnStr = split[0];
        String rawStr = split[1];

        int column = 0;
        int raw = Integer.parseInt(rawStr);
        switch (columnStr) {
            case "a":
                column = 1;
                break;
            case "b":
                column = 2;
                break;
            case "c":
                column = 3;
                break;
            case "d":
                column = 4;
                break;
            case "e":
                column = 5;
                break;
            case "f":
                column = 6;
                break;
            case "g":
                column = 7;
                break;
            case "h":
                column = 8;
                break;
        }

        List<int[]> moves = Arrays.asList(
                new int[]{2, 1},
                new int[]{2, -1},
                new int[]{-2, 1},
                new int[]{-2, -1},
                new int[]{1, 2},
                new int[]{-1, 2},
                new int[]{1, -2},
                new int[]{-1, -2}
        );

        System.out.println("column = " + column);
        System.out.println("raw = " + raw);
        
        int count = 0;
        for (int[] move : moves) {
            if(column + move[0] > 0 && column + move[0] <= 8 && raw + move[1] > 0 && raw + move[1] <= 8) {
                count++;
            }
        }

        return count;
    }
}
