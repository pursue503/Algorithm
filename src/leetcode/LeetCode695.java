package leetcode;

public class LeetCode695 {
    private int[][] grid;

    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};

    private int result = 0;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        int answer = -1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    if (result > answer) {
                        answer = result;
                    }
                }
                result = 0;
            }
        }
        return answer == -1 ? 0 : answer;
    }

    private void dfs(int x, int y) {

        grid[x][y] = 0;
        result++;

        for (int i = 0; i < moveX.length; i++) {

            int mX = x + moveX[i];
            int mY = y + moveY[i];

            // 상하 좌우 탐색
            if (mX <= -1 || mX >= grid.length || mY <= -1 || mY >= grid[0].length) {
                continue;
            }

            if (grid[mX][mY] == 1) {
                grid[mX][mY] = 0;
                dfs(mX, mY);
            }

        }
    }
}
