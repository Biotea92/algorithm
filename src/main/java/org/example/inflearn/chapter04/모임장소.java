package org.example.inflearn.chapter04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class 모임장소 {
    public int solution1(int[][] board){
        int answer=Integer.MAX_VALUE;

        List<List<Integer>> tmp = new LinkedList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    tmp.add(List.of(i, j));
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                int x = 0;
                int y = 0;

                for (List<Integer> integers : tmp) {
                    x += Math.abs(integers.get(0) - i);
                    y += Math.abs(integers.get(1) - j);
                }
                answer = Math.min(answer, x + y);
            }
        }

        return answer;
    }

    public int solution(int[][] board){
        int answer=0;
        int n = board.length;
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 1){
                    row.add(i);
                    col.add(j);
                }
            }
        }

        col.sort(Comparator.naturalOrder());

        int x = row.get(row.size()/2);
        int y = col.get(col.size()/2);

        for (int p : row) {
            answer += Math.abs(x - p);
        }
        for (int p : col) {
            answer += Math.abs(y - p);
        }
        return answer;
    }

    public static void main(String[] args){
        모임장소 T = new 모임장소();
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }
}
