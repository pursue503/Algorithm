package level02;

import java.util.Arrays;

/**
 *
 * 카카오프렌즈 컬러링북
 *
 */
public class Programmers1829 {

    static int[][] pictureArr;
    static boolean[][] visited;

    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visited = new boolean[m][n];
        pictureArr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pictureArr[i][j] = picture[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && pictureArr[i][j] != 0) {
                    int target = pictureArr[i][j];
                    int result = dfs(i, j, target);

                    if (result > maxSizeOfOneArea) {
                        maxSizeOfOneArea = result;
                    }
                    numberOfArea++;
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public int dfs(int x, int y, int target) {
        int answer = 1; // 방문했따는건 한개칸이 유효하다는거
        if (x <= -1 || x >= pictureArr.length || y <= -1 || y >= pictureArr[0].length) { // 범위 벗어날시 종료처리
            return 0; // 0값
        }

        if (visited[x][y] || pictureArr[x][y] == 0 || pictureArr[x][y] != target) { // 방문한 곳이거나 0값이면 종료
            return 0;
        }

        if (pictureArr[x][y] == target) { // 방문 하지 않은 곳이고 현재위치가 target 확인하려는 맵의 값이랑 같으면
            //방문처리
            visited[x][y] = true;
            //상하좌우 전부 탐색 시작
            answer += dfs(x - 1, y, target); // 상
            answer += dfs(x, y - 1, target); // 좌
            answer += dfs(x + 1, y, target); // 하
            answer += dfs(x, y + 1, target); // 우
        }

        return answer;
    }

    public static void main(String[] args) {
        Programmers1829 programmers1829 = new Programmers1829();
        System.out.println(Arrays.toString(programmers1829.solution(6, 4, new int[][]{
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        })));

        System.out.println(Arrays.toString(programmers1829.solution(2, 2, new int[][]{
                {1, 1}, {0, 1}
        })));
        System.out.println(Arrays.toString(programmers1829.solution(6, 4, new int[][]{
                {1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}

        })));

        System.out.println(Arrays.toString(programmers1829.solution(6, 4, new int[][]{
                {1, 0, 0, 1}, {1, 0, 0, 1}, {1, 0, 0, 1}, {1, 0, 0, 1}, {1, 0, 0, 1}, {1, 1, 1, 1}

        })));
        System.out.println(Arrays.toString(programmers1829.solution(1, 1, new int[][]{
                {0}
        })));

        System.out.println(Arrays.toString(programmers1829.solution(4, 4, new int[][]{
                {1, 1, 1, 1}, {1, 4, 1, 1}, {1, 3, 2, 1}, {1, 1, 1, 1}
        })));


//        System.out.println(Arrays.toString(programmers1829.solution(3, 3, new int[][]{
//                {0, 1, 0},
//                {1, 1, 0},
//                {0, 0, 0}
//        })));

    }

}
