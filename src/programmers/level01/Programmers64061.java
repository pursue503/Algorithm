package level01;

import java.util.ArrayList;

/**
 * 크레인 인형뽑기
 */

public class Programmers64061 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}};
        System.out.println(solution(arr, new int[]{1, 5, 3, 5, 1, 2, 1, 4}));
    }


    public static int solution(int[][] board, int[] moves) {
        // moves 뽑기,
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<>();

        int max = board.length;

        for (int i = 0; i < moves.length; i++) {
            int num = moves[i];
            int count = 0;
            while (count < max) {
                int click = board[count][num - 1];
                if (click != 0) {
                    list.add(click);
                    board[count][num -1] = 0;
                    break;
                }
                count++;
            }

            if (list.size() > 1) {
                if (list.get(list.size() - 1).equals(list.get(list.size() - 2))) {
                    list.remove(list.size() - 1);
                    list.remove(list.size() - 1);
                    answer++;
                }
            }

        }

        return answer * 2;
    }

}
