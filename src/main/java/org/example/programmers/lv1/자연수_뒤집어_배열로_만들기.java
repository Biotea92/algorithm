package org.example.programmers.lv1;

import java.util.Arrays;

public class 자연수_뒤집어_배열로_만들기 {
/*
    문제 설명
    자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

    제한 조건
    n은 10,000,000,000이하인 자연수입니다.
*/

    // 비효율 그자체 stream으로 처리하면 느림
    public int[] solution(long n) {
        String str = String.valueOf(n);
        String reversed = new StringBuilder(str).reverse().toString();
        return Arrays.stream(reversed.split("")).mapToInt(Integer::parseInt).toArray();
    }

    public int[] solution1(long n) {
        String str = String.valueOf(n);
        String reversed = new StringBuilder(str).reverse().toString();
        char[] arr = reversed.toCharArray();

        int[] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i] - '0';
        }
        return answer;
    }

    // 속도 빠름
    public int[] solution2(long n) {
        String str = String.valueOf(n);
        int[] answer = new int[str.length()];
        int index = 0;

        while(n > 0) {
            answer[index++] = (int)(n % 10);
            n /= 10;
        }

        return answer;
    }
}
