class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(i, j, grid);
                }
            }
        }

        return numIslands;
    }

    private void dfs(int row, int col, char[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length
            || grid[row][col] == '0') {
            return;
        }

        // mark this cell as visited
        grid[row][col] = '0';
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int[] dir : directions) {
            dfs(row + dir[0], col + dir[1], grid);
        }
    }
}
