class Solution {
    private int m;
    private int n;
    private int[][] dp;
    private int[][] matrix;
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;

        // dp[i][j] = length of longest strictly increasing path from (i,j)
        dp = new int[m][n];
        int res = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(i, j));
            }
        }

        return res;
    }

    private int dfs(int row, int col) {
        // If answer is already computed, return it
        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int longest = 1;

        for (int[] dir : directions) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                if (matrix[nr][nc] > matrix[row][col]) {
                    longest = Math.max(longest, 1 + dfs(nr, nc));
                }
            }
        }

        dp[row][col] = longest;
        return longest;
    }
}
