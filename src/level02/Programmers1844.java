package level02;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 게임 맵 최단거리
 *
 */

public class Programmers1844 {

    // 상하좌우
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};

    public int solution(int[][] maps) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0));

        while (!queue.isEmpty()) {

            Node node = queue.poll(); // 값을꺼냄
            //현재 노드 좌표 꺼내기
            int x = node.getX();
            int y = node.getY();

            for(int i=0; i<4; i++) { //상하좌우 탐색 시작

                //새롭게 이동할 노드
                int mX = x + moveX[i];
                int mY = y + moveY[i];

                //밖인지 확인하기 또는 벽
                if(mX <= -1 || mX >= maps.length || mY <= -1 || mY >= maps[0].length || maps[mX][mY] == 0) {
                    continue;
                }

                //방문한곳은 상관없고 현재 값보다 작은지..
                if(maps[mX][mY] == 1) {
                    maps[mX][mY] = maps[x][y] + 1; //변경해주고
                    queue.add(new Node(mX, mY));
                }

            }

        }
        int answer = maps[maps.length - 1][ maps[0].length -1];
        return answer != 1 ? answer : -1;
    }

    public static void main(String[] args) {
        Programmers1844 programmers1844 = new Programmers1844();
        System.out.println(programmers1844.solution(new int[][]{
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        }));
    }

}

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
}
