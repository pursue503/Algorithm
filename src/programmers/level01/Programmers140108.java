package programmers.level01;

import java.util.function.Consumer;

public class Programmers140108 {

    static boolean[][] visited;
    static int maxY;
    static int maxX;

    static int startY;
    static int startX;

    public int[] solution(String[] park, String[] routes) {
        maxY = park.length;
        maxX = park[0].length();
        initVisited(park);
        return calculate(routes);
    }

    private void initVisited(String[] park) {
        visited = new boolean[maxY][maxX];

        for (int i = 0; i < park.length; i++) {
            String line = park[i];
            for (int j = 0; j < line.length(); j++) {
                String block = String.valueOf(line.charAt(j));

                if (block.equals("S")) {
                    startY = i;
                    startX = j;
                    visited[i][j] = true;
                    continue;
                }

                if (block.equals("O")) {
                    visited[i][j] = true;
                }
            }
        }

    }

    private int[] calculate(String[] routes) {
        for (String route : routes) {
            String[] arr = route.split(" ");
            String direction = arr[0];
            int move = Integer.parseInt(arr[1]);
            Calculator.calculate(direction, move);
        }

        return new int[]{startY, startX};
    }


    enum Calculator {
        N(move -> {
            if (startY - move < 0 ) {
                return;
            }

            for (int i = startY; i >= startY - move; i--) {
                if (!visited[i][startX]) {
                    return;
                }
            }
            startY -= move;
        }),
        S(move -> {
            if (startY + move >= maxY) {
                return;
            }
            for (int i = startY; i <= startY + move; i++) {
                if (!visited[i][startX]) {
                    return;
                }
            }

            startY += move;
        }),
        W(move -> {
            if (startX - move < 0) {
                return;
            }

            for (int i = startX; i >= startX - move; i--) {
                if (!visited[startY][i]) {
                    return;
                }
            }

            startX -= move;
        }),
        E(move -> {

            if (startX + move >= maxX) {
                return;
            }

            for (int i = startX; i <= startX + move; i++) {
                if (!visited[startY][i]) {
                    return;
                }
            }
            startX += move;
        })
        ;

        private Consumer<Integer> consumer;

        Calculator(Consumer<Integer> consumer) {
            this.consumer = consumer;
        }

        public static void calculate(String direction, int move) {
            Calculator.valueOf(direction.toUpperCase()).consumer.accept(move);
        }

    }

}
