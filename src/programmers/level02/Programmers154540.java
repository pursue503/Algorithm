package programmers.level02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Programmers154540 {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Programmers154540().solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"})));
        System.out.println(Arrays.toString(new Programmers154540().solution(new String[]{"X5XX5X", "111111", "XXXXXX", "111111"})));
    }

    static int[] moveRow = {-1, 1, 0, 0};
    static int[] moveColumn = {0, 0, -1, 1};
    public int[] solution(String[] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        int[][] nodes = new int[maps.length][maps[0].length()];

        for (int row = 0; row < maps.length; row++) {
            String rows = maps[row];
            for (int column = 0; column < rows.length(); column++) {
                if (String.valueOf(rows.charAt(column)).equals("X")) {
                    nodes[row][column] = -1;
                } else {
                    nodes[row][column] = Character.getNumericValue(rows.charAt(column));
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int row = 0; row < nodes.length; row++) {
            for (int column = 0; column < nodes[row].length; column++) {
                if (!visited[row][column] && nodes[row][column] != -1) {
                    list.add(dfs(nodes, visited, row, column));
                }
            }
        }

        if (list.isEmpty()) {
            return new int[]{-1};
        }

        return list.stream()
                .sorted(Comparator.comparingInt(o -> o))
                .mapToInt(it -> it)
                .toArray();
    }

    public int dfs(int[][] nodes, boolean[][] visited, int row, int column) {

        visited[row][column] = true;

        int answer = nodes[row][column];

        for (int i = 0; i < 4; i++) {

            int nextRow = row + moveRow[i];
            int nextColumn = column + moveColumn[i];


            if (nextRow < 0 || nextRow >= nodes.length || nextColumn < 0 || nextColumn >= nodes[0].length) {
                continue;
            }

            if (!visited[nextRow][nextColumn] && nodes[nextRow][nextColumn] != -1) {
                answer += dfs(nodes , visited, nextRow, nextColumn);
            }

        }
        return answer;
    }

}
