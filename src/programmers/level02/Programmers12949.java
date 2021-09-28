package level02;

/**
 *
 * 행렬의 곱셈
 *
 */

public class Programmers12949 {

    public static void main(String[] args) {
        Programmers12949 programmers12949 = new Programmers12949();
        programmers12949.print(programmers12949.solution(new int[][]{
                {1, 4},
                {3, 2},
                {4, 1}
        }, new int[][]{
                {3, 3},
                {3, 3}
        }));

        programmers12949.print(programmers12949.solution(new int[][]{
                {2, 3, 2},
                {4, 2, 4},
                {3, 1, 4}
        }, new int[][]{
                {5, 4, 3},
                {2, 4, 1},
                {3, 1, 1}
        }));

        programmers12949.print(programmers12949.solution(new int[][]{
                {2, 3, 2},
                {4, 2, 4},
                {3, 1, 4}
        }, new int[][]{
                {5, 4},
                {2, 4},
                {3, 1}
        }));

        programmers12949.print(programmers12949.solution(new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        }, new int[][]{
                {1, 4},
                {2, 5},
                {3, 6}
        }));

    }

    public int[][] solution(int[][] arr1, int[][] arr2) {

        int row = arr1.length;
        int column = arr2[0].length;


        int[][] answer = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int num = 0;
                for (int k = 0; k < arr1[0].length; k++) {
                    num += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = num;
            }
        }
        return answer;
    }

    public void print(int[][] print) {

        for (int i = 0; i < print.length; i++) {
            for (int j = 0; j < print[i].length; j++) {
                System.out.print(print[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

}
