package org.example.backjun;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        for (int i = 0; i < testCount; i++) {
            int n = scanner.nextInt();
            solution(n);
        }
    }

    public static void solution(int n) {
        char[] chars = Integer.toBinaryString(n).toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '1') {
                System.out.print(chars.length - 1 - i + " ");
            }
        }
    }
}
