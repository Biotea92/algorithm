package org.example.programmers.lv2;

public class 쿼드압축_후_개수_세기 {

    private static int[] answer = new int[2];
    private final int ZERO = 0;
    private final int ONE = 1;

    public int[] solution(int[][] arr) {
        if (!checkSameNumber(arr))
            split(arr);
        return answer;
    }

    private boolean checkSameNumber(int[][] arr) {
        int countZero = 0;
        int countOne = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt == ZERO) {
                    countZero++;
                } else {
                    countOne++;
                }
            }
        }
        if (countZero == 0) {
            answer[ONE]++;
            return true;
        } else if (countOne == 0) {
            answer[ZERO]++;
            return true;
        }
        return false;
    }

    public void split(int[][] arr) {
        int length = arr.length;
        int dividedLength = length / 2;
        if (dividedLength == 1) {
            count(arr);
            return;
        }

        int[][] sectorA = new int[dividedLength][dividedLength];
        int indexI = 0;
        int indexJ = 0;
        int countZero = 0;
        int countOne = 0;
        for (int i = 0; i < dividedLength; i++) {
            indexJ = 0;
            for (int j = 0; j < dividedLength; j++) {
                sectorA[indexI][indexJ] = arr[i][j];
                indexJ++;
                if (arr[i][j] == ZERO) {
                    countZero++;
                } else {
                    countOne++;
                }
            }
            indexI++;
        }

        count(countZero, countOne, sectorA);

        int[][] sectorB = new int[dividedLength][dividedLength];
        indexI = 0;
        countZero = 0;
        countOne = 0;
        for (int i = 0; i < dividedLength; i++) {
            indexJ = 0;
            for (int j = dividedLength; j < length; j++) {
                sectorB[indexI][indexJ] = arr[i][j];
                indexJ++;
                if (arr[i][j] == ZERO) {
                    countZero++;
                } else {
                    countOne++;
                }
            }
            indexI++;
        }

        count(countZero, countOne, sectorB);

        int[][] sectorC = new int[dividedLength][dividedLength];
        indexI = 0;
        countZero = 0;
        countOne = 0;
        for (int i = dividedLength; i < length; i++) {
            indexJ = 0;
            for (int j = 0; j < dividedLength; j++) {
                sectorC[indexI][indexJ] = arr[i][j];
                indexJ++;
                if (arr[i][j] == ZERO) {
                    countZero++;
                } else {
                    countOne++;
                }
            }
            indexI++;
        }

        count(countZero, countOne, sectorC);

        int[][] sectorD = new int[dividedLength][dividedLength];
        indexI = 0;
        countZero = 0;
        countOne = 0;
        for (int i = dividedLength; i < length; i++) {
            indexJ = 0;
            for (int j = dividedLength; j < length; j++) {
                sectorD[indexI][indexJ] = arr[i][j];
                indexJ++;
                if (arr[i][j] == ZERO) {
                    countZero++;
                } else {
                    countOne++;
                }
            }
            indexI++;
        }

        count(countZero, countOne, sectorD);
    }

    private void count(int countZero, int countOne, int[][] sector) {
        if (countZero == 0) {
            answer[ONE]++;
        } else if (countOne == 0) {
            answer[ZERO]++;
        } else {
            split(sector);
        }
    }

    public void count(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt == ZERO) {
                    answer[ZERO]++;
                } else {
                    answer[ONE]++;
                }
            }
        }
    }
}
