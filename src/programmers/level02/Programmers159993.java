package programmers.level02;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers159993 {


    static int[] moveRow = {-1, 1, 0, 0};
    static int[] moveColumn = {0, 0, -1, 1};

    public int solution(String[] maps) {
        int answer = 0;
        int[][] nodes = new int[maps.length][maps[0].length()];
        Node start = null;

        for (int row = 0; row < maps.length; row++) {
            String line = maps[row]; // 한줄
            for (int column = 0; column < line.length(); column++) {
                String node = String.valueOf(line.charAt(column));

                if (node.equals("S")) {
                    if (nodeValid(maps, row, column)) {
                        return -1;
                    }
                    start = new Node(row, column, 0);
                    nodes[row][column] = 1;
                } else if (node.equals("E")) {
                    if (nodeValid(maps, row, column)) {
                        return -1;
                    }
                    nodes[row][column] = 2;
                } else if (node.equals("L")) {
                    if (nodeValid(maps, row, column)) {
                        return -1;
                    }
                    nodes[row][column] = 3;
                } else if (node.equals("O")) {
                    nodes[row][column] = 4;
                } else {
                    nodes[row][column] = -1;
                }
            }
        }

        Node node = bfs(start, 3, nodes);

        if (node.getCount() == -1) {
            return -1;
        }

        answer += node.getCount();

        node = bfs(new Node(node.getRow(), node.getColumn(), 0), 2, nodes);

        if (node.getCount() == -1) {
            return -1;
        }

        return answer + node.getCount();
    }

    private boolean nodeValid(String[] maps, int row, int column) {

        int count = 0;

        for (int i = 0; i < 4; i++) {
            int validRow = row + moveRow[i];
            int validColumn = column + moveColumn[i];

            if (validRow < 0 || validRow >= maps.length || validColumn < 0 || validColumn >= maps[validRow].length()) {
                count++;
                continue;
            }

            String node = String.valueOf(maps[validRow].charAt(validColumn));
            if (node.equals("X")) {
                count++;
            }

        }
        return count == 4;
    }

    private Node bfs(Node start, int flag, int[][] nodes) {

        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[nodes.length][nodes[0].length];
        queue.add(start);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            ; // node 꺼내기

            int row = node.getRow();
            int column = node.getColumn();
            visited[row][column] = true; // 본인 방문 처리

            for (int i = 0; i < 4; i++) { // 상하 좌우 탐색

                int nextRow = row + moveRow[i];
                int nextColumn = column + moveColumn[i];

                if (nextRow <= -1 || nextRow >= nodes.length || nextColumn <= -1 || nextColumn >= nodes[0].length || nodes[nextRow][nextColumn] == -1) {
                    continue;
                }

                if (nodes[nextRow][nextColumn] == flag) {
                    return new Node(nextRow, nextColumn, node.getCount() + 1);
                }

                if (!visited[nextRow][nextColumn]) {
                    visited[nextRow][nextColumn] = true;
                    queue.add(new Node(nextRow, nextColumn, node.getCount() + 1));
                }

            }
        }

        return new Node(0, 0, -1);
    }

}


class Node {

    private int row;
    private int column;
    private int count;

    public Node(int row, int column, int count) {
        this.row = row;
        this.column = column;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}