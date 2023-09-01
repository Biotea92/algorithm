package org.example.thisiscodingtest.chapter04;

public class 구현_상하좌우 {

    public int[] solution(int n, String[] moves) {
        int column = 1;
        int raw = 1;

        for (String move : moves) {
            switch (move) {
                case "L":
                    if (column == 1) {
                        break;
                    } else {
                        column--;
                    }
                    break;
                case "R":
                    if (column == n) {
                        break;
                    } else {
                        column++;
                    }
                    break;
                case "U":
                    if (raw == 1) {
                        break;
                    } else {
                        raw--;
                    }
                    break;
                case "D":
                    if (raw == n) {
                        break;
                    } else {
                        raw++;
                    }
                    break;
            }
            System.out.println("column = " + column);
            System.out.println("raw = " + raw);
            System.out.println("==================");
        }

        return new int[] {raw, column};
    }

}
