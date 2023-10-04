package org.example.study.radix;

public class Radix {

    public static void main(String[] args) {
        String binary = "1010";
        int value = Integer.parseInt(binary, 2);
        System.out.println(value);
        String hex = Integer.toString(value, 16);
        System.out.println(hex);
        System.out.println(hex.toUpperCase());
    }
}
