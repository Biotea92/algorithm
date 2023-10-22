package org.example.samsumg;

public class 부분_집합의_합 {

/*
    1부터 N까지 양의 정수를 원소로 갖는 집합이 있다. 이 집합의 모든 부분 집합에 대해 원소의 합이 K인 경우의 수 M을 알아내려고 한다.

    부분 집합의 개수는 2N개이기 때문에 모든 부분 집합을 만들어 확인하려면 시간이 오래 걸리지만,
    정수 i를 부분 집합에 포함시킬지 고려할 때 이미 부분 집합에 포함시킨 원소의 합 S와 아직 고려하지 않은 숫자들의 합 R을 동시에 활용하면 시간을 단축할 수 있다고 한다.

    이를 활용해 M을 출력하는 프로그램을 만드시오.

    ( 3<=N<=100, 6<=K<=모든 원소의 합 )
*/

    public int solution(int N, int K) {
        if (N >= K) {
            N = K;
        }
        int[][] dp  = new int[N + 1][K + 1];
        dp[0][0] = 1;

        for (int n = 1; n <= N; n++) {
            for (int k = 0; k <= K; k++) {
                dp[n][k] = dp[n - 1][k];
                if (k - n >= 0) {
                    dp[n][k] += dp[n - 1][k - n];
                }
            }
        }

        return dp[N][K];
    }
}
