package org.example.inflearn.chapter01;

public class 과일가져가기 {

    public int solution(int[][] fruit) {
        int answer = 0;
        int n = fruit.length;
        int[] check = new int[n];

        for (int i = 0; i < n; i++) {
            if (check[i] == 1)
                continue;
            if (isUniqueMinValue(fruit[i]) == false)
                continue;

            for (int j = i + 1; j < n; j++) {
                if (check[j] == 1)
                    continue;
                if (isUniqueMinValue(fruit[j]) == false)
                    continue;

                int indexA = getMinIndex(fruit[i]);
                int indexB = getMinIndex(fruit[j]);

                if (indexA != indexB && fruit[i][indexB] > 0 && fruit[j][indexA] > 0) {
                    if (fruit[i][indexA] + 1 < fruit[i][indexB] - 1 && fruit[j][indexB] + 1 < fruit[j][indexA] - 1) {
                        fruit[i][indexA]++;
                        fruit[i][indexB]--;
                        fruit[j][indexB]++;
                        fruit[j][indexA]--;

                        check[i] = 1;
                        check[j] = 1;
                        break;
                    }
                }
            }
        }

        for (int[] f : fruit) {
            answer += getMin(f);
        }


        return answer;
    }

    private int getMinIndex(int[] fruits) {
        int min = getMin(fruits);
        for (int i = 0; i < 3; i++) {
            if (fruits[i] == min) {
                return i;
            }
        }

        return 0;
    }

    private boolean isUniqueMinValue(int[] fruits) {
        int minValue = getMin(fruits);

        int count = 0;
        for (int fruit : fruits) {
            if (fruit == minValue)
                count++;
        }

        return count == 1;
    }

    public int getMin(int[] fruits) {
        int minValue = 50;
        for (int fruit : fruits) {
            minValue = Math.min(minValue, fruit);
        }
        return minValue;
    }

    public static void main(String[] args) {
        과일가져가기 T = new 과일가져가기();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}
