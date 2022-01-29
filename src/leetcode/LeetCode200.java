package leetcode;

/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 */

public class LeetCode200 {

    private boolean[][] visited;

    // 상하좌우
    private int[] moveX = {-1, 1, 0, 0};
    private int[] moveY = {0, 0, -1, 1};

    public int numIslands(char[][] grid) {

        int answer = 0;

        visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') { // 미방문 및 섬일경우
                    dfs(i, j, grid);
                    answer++;
                }
            }
        }
        return answer;
    }

    public void dfs(int x, int y, char[][] grid) {

        visited[x][y] = true; // 본인 방문 처리

        // 상하 좌우 추가
        for (int move = 0; move < 4; move++) {

            int mX = x + moveX[move];
            int mY = y + moveY[move];

            //밖인지 확인하기 또는 벽
            if (mX <= -1 || mX >= visited.length || mY <= -1 || mY >= visited[0].length) { // visited == grid 같음 length가
                continue;
            }

            if (!visited[mX][mY] && grid[mX][mY] == '1') { // 미방문 이고 섬일경우
                dfs(mX, mY, grid);
            }

        }

    }

}
