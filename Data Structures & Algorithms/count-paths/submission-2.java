class Solution {
    public int uniquePaths(int m, int n) {
        // dp[i] = number of unique paths to reach this row and column i
        int[] dp = new int[n];

        // First row -> 1 unique path for all cells
        Arrays.fill(dp, 1);

        for (int row = 1; row < m; row++) {
            int[] prevRow = new int[n];
            for (int i = 0; i < n; i++) {
                prevRow[i] = dp[i];
            }

            for (int col = 1; col < n; col++) {
                dp[col] = prevRow[col] + dp[col-1];
            }
        }

        return dp[n-1];
    }
}
