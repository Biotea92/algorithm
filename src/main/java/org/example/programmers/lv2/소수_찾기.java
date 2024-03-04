package org.example.programmers.lv2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class 소수_찾기 {

    public int solution(String numbers) {
        Set<Integer> primes = new HashSet<>();
        List<Integer> nums = numbers.chars()
                .map(c -> c - '0')
                .boxed()
                .collect(Collectors.toList());
        getPrimes(0, nums, primes);
        return primes.size();
    }

    private void getPrimes(int acc, List<Integer> numbers, Set<Integer> primes) {
        // 종료 조건, 점화식
        if (isPrime(acc))
            primes.add(acc);

        for (int i = 0; i < numbers.size(); i++) {
            int nextAcc = acc * 10 + numbers.get(i);
            List<Integer> nextNumbers = new ArrayList<>(numbers);
            nextNumbers.remove(i);
            getPrimes(nextAcc, nextNumbers, primes);
        }
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


}
