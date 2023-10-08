package org.example.study.recursion;

public class Recursion {

    public static void main(String[] args) {
        int n = 2;
        int m = 10;

        int solution = solution(n, m);
        System.out.println("solution = " + solution);
    }

    public static int solution(int n, int m) {
        if (m < 1) {
            return 1;
        }
        return n * solution(n ,m - 1);
    }
}
