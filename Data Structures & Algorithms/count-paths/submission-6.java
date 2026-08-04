class Solution {
    public int uniquePaths(int m, int n) {  
        // dp[j] = number of possible unique paths to go to cell j in the current row
        int[] dp = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] += dp[j-1];
                }
            }
        }

        return dp[n-1];
    }
}
