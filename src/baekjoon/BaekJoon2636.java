package baekjoon;

import java.io.*;
import java.util.*;

class Node {

    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    @Override
    public boolean equals(Object obj) {
        Node node = (Node) obj;
        return node.x == this.x && node.y == this.y;
    }
}

public class BaekJoon2636 {

    // 상하좌우
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Node> queue = new LinkedList<>();
        Set<Node> remove = new HashSet<>();

        int count = 0;
        int removeCount = 0;

        while (true) {

            queue.add(new Node(0, 0));

            while (!queue.isEmpty()) { // 탐색 시작

                Node node = queue.poll();
                int x = node.getX();
                int y = node.getY();

                for (int move = 0; move < 4; move++) {

                    int mX = x + moveX[move];
                    int mY = y + moveY[move];

                    //밖인지 확인하기 또는 벽
                    if (mX <= -1 || mX >= arr.length || mY <= -1 || mY >= arr[0].length) {
                        continue;
                    }

                    if (!visited[mX][mY]) {

                        if (arr[mX][mY] == 1) {
                            remove.add(new Node(mX, mY));
                        } else {
                            visited[mX][mY] = true;
                            queue.add(new Node(mX, mY));
                        }

                    }

                }

            } // end while


            int tempCount = 0;

            Iterator<Node> iterator = remove.iterator();
            while (iterator.hasNext()) {
                Node node = iterator.next();

                int x = node.getX();
                int y = node.getY();

//                    System.out.println("remove : " + x + ", " + y);

                if (arr[x][y] != 0) {
                    tempCount++;
                    arr[x][y] = 0;
                }
            }

            if (tempCount == 0) break;
//                    System.out.println("remove All Count : " + tempCount);
            removeCount = tempCount;
            count++;
//                    System.out.println();
            visited = new boolean[N][M];


            remove.clear();


        }

        bw.write(String.valueOf(count));
        bw.write("\n");
        bw.write(String.valueOf(removeCount));
        bw.flush();
        br.close();
        bw.close();
    } // end main

}


