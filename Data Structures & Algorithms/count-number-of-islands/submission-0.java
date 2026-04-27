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
            || grid[row][col] != '1') {
            return;
        }

        // mark this cell as visited
        grid[row][col] = '#';
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int[] dir : directions) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            dfs(nextRow, nextCol, grid);
        }
    }
}
