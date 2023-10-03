package org.example.backjun;

import java.util.Arrays;

public class LCS {
/*
    문제
    LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.

    예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.

    입력
    첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.

    출력
    첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를 출력한다.

*/

    public int solution(String str1, String str2) {

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            char c1 = str1.charAt(i - 1);
            for (int j = 1; j <= str2.length(); j++) {
                char c2 = str2.charAt(j - 1);

                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // 대각선 위의 값 + 1
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // 왼쪽 값과 위쪽 값 중 큰 값
                }
            }
        }

        return dp[str1.length()][str2.length()];
    }
}
