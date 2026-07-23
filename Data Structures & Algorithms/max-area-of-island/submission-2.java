class Solution {
    private static final int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int maxArea = 0;
    private int m;
    private int n;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(i, j, grid));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int row, int col, int[][] grid) {
        // Mark this cell as visited
        grid[row][col] = -1;

        int area = 1;

        for (int[] dir : directions) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                area += dfs(nr, nc, grid);
            }
        }

        return area;
    }
}
