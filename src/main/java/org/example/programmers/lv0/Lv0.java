package org.example.programmers.lv0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lv0 {

    public static void main(String[] args) {
        int[] ints = solution14(15000);
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }

    // 약수 구하기 https://school.programmers.co.kr/learn/courses/30/lessons/120897
    public int[] solution1(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < n + 1 ; i++) {
            if ((n % i) == 0) {
                result.add(i);
            }
        }
        return result.stream().mapToInt(num -> num).toArray();
    }

    // 중복된 숫자 개수 https://school.programmers.co.kr/learn/courses/30/lessons/120583
    public int solution2(int[] array, int n) {
        int answer = 0;
        for(int i : array) {
            if (i == n) {
                answer++;
            }
        }
        return answer;
    }

    // 머쓱이보다 키 큰 사람 https://school.programmers.co.kr/learn/courses/30/lessons/120585
    public int solution3(int[] array, int height) {
        int answer = 0;
        for(int n : array) {
            if(n > height)
                answer++;
        }
        return answer;
    }

    // 두수의 나눗셈 https://school.programmers.co.kr/learn/courses/30/lessons/120806
    public static int solution4(int num1, int num2) {
        double result = (double) num1 / num2;
        return (int) (result * 1000);
    }

    // 분수의 덧셈 https://school.programmers.co.kr/learn/courses/30/lessons/120808
    public int[] solution5(int numer1, int denom1, int numer2, int denom2) {
        int denom = denom1 * denom2;
        int num = (numer1 * denom2) + (numer2 * denom1);

        int length = Math.max(denom, num);

        // 최소공배수를 나눌때 높은 수부터 나눌 것
        for(int i = length; i > 1; i--) {
            if ((num % i == 0) && (denom % i == 0)) {
                num = num / i;
                denom = denom / i;
            }
        }

        int[] answer = {num, denom};
        return answer;
    }

    // 배열 두배 만들기 https://school.programmers.co.kr/learn/courses/30/lessons/120809
    public int[] solution6(int[] numbers) {
        return Arrays.stream(numbers)
                .map(n -> n * 2)
                .toArray();
    }

    // 중앙값 구하기 https://school.programmers.co.kr/learn/courses/30/lessons/120811
    public static int solution7(int[] array) {
        List<Integer> result = Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList());

        int range = (array.length - 1) / 2;
        for (int i = 0; i < range; i++) {
            result.remove(result.stream().reduce(Integer::max).get());
            result.remove(result.stream().reduce(Integer::min).get());
        }
        return result.get(0);
    }

    // 중앙값 구하기 좋은 방법
    public static int solution8(int[] array) {
        Arrays.sort(array);

        return array[array.length/2];
    }

    // 최빈값 구하기 https://school.programmers.co.kr/learn/courses/30/lessons/120812
    /**
     * 최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다. 정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요. 최빈값이 여러 개면 -1을 return 합니다.
     */
    public static int solution9(int[] array) {
        int answer = array[0];

        int max = 0;
        int[] frequent = new int[1000];

        for (int i : array) {
            frequent[i]++;
            System.out.println(frequent[i]);

            if (max < frequent[i]) {
                max = frequent[i];
                answer = i;
            }
        }

        int temp = 0;
        for (int i = 0; i < 1000; i++) {
            if (max == frequent[i])
                temp++;
            if (temp > 1)
                answer = -1;
        }

        return answer;
    }

    // 짝수는 싫어요 https://school.programmers.co.kr/learn/courses/30/lessons/120813
    public static int[] solution10(int n) {
        return IntStream.range(1, n+1).filter(x -> x % 2 == 1).toArray();
    }

    // 피자 나누기 2
    public static int solution11(int n) {
        int pizza = 6;
        while(pizza % n != 0) {
            pizza = pizza + 6;
        }
        return pizza / 6;
    }

    public static double solution12(int[] numbers) {
        Arrays.stream(numbers).average().getAsDouble();
        return Arrays.stream(numbers).asDoubleStream().average().getAsDouble();
    }

    public static int solution13(int price) {
        price = 123450;
        int[] limitPrice = new int[] {500_000, 300_000, 100_000};
        double[] discount = new double [] {0.80, 0.90, 0.95};

        if (price < 100_000) {
            return price;
        }

        double answer = price;
        for (int i = 0; i < limitPrice.length; i++) {
            if (price >= limitPrice[i]) {
                answer = answer * discount[i];
                break;
            }
        }
        return (int) answer ;
    }

    public static int[] solution14(int money) {

        return new int[] {money / 5500, money % 5500};
    }
}
