package org.example.thisiscodingtest.chapter04;

public class 구현_시각 {

    public int solution(int n) {
        String strN = String.valueOf(n);
        int count = 0;
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    if (String.valueOf(i).contains(strN) || String.valueOf(j).contains(strN) || String.valueOf(k).contains(strN)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
