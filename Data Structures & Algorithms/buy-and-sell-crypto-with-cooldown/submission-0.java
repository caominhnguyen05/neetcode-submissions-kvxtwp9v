class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        // dp[i][j] = max profit from day i onwards given whether we're holding a stock
        int[][] dp = new int[n + 2][2];

        for (int i = n - 1; i >= 0; i--) {
            // Not holding a stock
            dp[i][0] = dp[i+1][0]; // do nothing
            dp[i][0] = Math.max(dp[i][0], -prices[i] + dp[i+1][1]); // buy stock today

            // Holding a stock -> do nothing or sell and cooldown
            dp[i][1] = Math.max(dp[i+1][1], prices[i] + dp[i+2][0]);
        }

        return dp[0][0];
    }
}
