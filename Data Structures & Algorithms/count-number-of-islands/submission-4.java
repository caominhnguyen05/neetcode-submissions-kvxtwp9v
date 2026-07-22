class Solution {
    private static final int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(i, j, grid);
                }
            }
        }

        return res;
    }

    private void dfs(int row, int col, char[][] grid) {
        // mark this cell as visited
        grid[row][col] = '#';

        for (int[] dir : directions) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (0 <= nr && nr < m && 0 <= nc && nc < n && grid[nr][nc] == '1') {
                dfs(nr, nc, grid);
            }
        }
    }
}
