package baekjoon;

import java.io.*;
import java.util.*;

/**
 *
 * 백준 빙산
 *
 */

public class BaekJoon2573 {

    // 상하좌우
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};

    static boolean[][] visited;
    static int[][] arr;

    static Queue<IceNode> queue = new LinkedList<>();
    static Queue<IceNode> remove = new LinkedList<>();

    static int nodeCount = 0;

    public static void main(String[] args) throws IOException {

        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag;

        while (true) {

            flag = false;
            nodeCount = 0;

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {


                    if (flag && arr[i][j] != 0 && !visited[i][j]) {
                        bw.write(String.valueOf(answer - 1));
                        bw.close();
                        return;
                    }

                    if (!visited[i][j] && arr[i][j] != 0) { // 미방문 + 빙하여야 돔

                        flag = true; // 이번 사이클에 방문했음
                        nodeCount++;

                        queue.add(new IceNode(i, j));
                        visited[i][j] = true; // 본인 방문처리

                        bfs();
                        remove();

                        answer++;

                    }

                }

            } // end other for

            visited = new boolean[N][M];

            if (nodeCount == 0) {
                bw.write(String.valueOf(0));
                bw.close();
                return;
            }
        }


    }

    private static void bfs() {
        while (!queue.isEmpty()) {

            IceNode iceNode = queue.poll();

            int x = iceNode.getX();
            int y = iceNode.getY();


            for (int move = 0; move < 4; move++) {

                int mX = x + moveX[move];
                int mY = y + moveY[move];

                //밖인지 확인하기 또는 벽
                if (mX <= -1 || mX >= arr.length || mY <= -1 || mY >= arr[0].length) {
                    continue;
                }

                if (arr[mX][mY] == 0 && arr[x][y] != 0) {
                    remove.add(new IceNode(x, y));
                }

                if (!visited[mX][mY] && arr[mX][mY] != 0) {
                    nodeCount++;
                    visited[mX][mY] = true;
                    queue.add(new IceNode(mX, mY));
                }

            }

        } // end while
    }

    public static void remove() {
        while (!remove.isEmpty()) {

            IceNode iceNode = remove.poll();

            int x = iceNode.getX();
            int y = iceNode.getY();


            if (arr[x][y] != 0) {
                arr[x][y] -= 1;
            }

        }
    }
}


class IceNode {

    private int x;
    private int y;

    public IceNode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
