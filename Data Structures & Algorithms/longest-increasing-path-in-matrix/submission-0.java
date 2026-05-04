class Solution {
    private int[][] matrix;
    private int[][] dp;
    private int rows;
    private int cols;
    private final int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        
        // dp[r][c] = length of longest increasing path starting at matrix[r][c]
        this.dp = new int[rows][cols];
        int answer = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                answer = Math.max(answer, dfs(r, c));
            }
        }

        return answer;
    }

    private int dfs(int row, int col) {
        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int best = 1;

        for (int[] dir : directions) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (0 <= nr && nr < rows && 0 <= nc && nc < cols && matrix[nr][nc] > matrix[row][col]) {
                best = Math.max(best, 1 + dfs(nr, nc));
            }
        }

        dp[row][col] = best;
        return best;
    }
}
