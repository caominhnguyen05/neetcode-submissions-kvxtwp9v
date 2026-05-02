class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        // dp[i][j] = number of ways to make amount j using the first i types of coins
        int[][] dp = new int[n + 1][amount + 1];

        // Base case: there is 1 way to make amount 0
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                // Option 1: don't use the current coin
                // number of ways remain the same as without this coin
                dp[i][j] = dp[i-1][j];

                // Option 2: Use the current coin (if amount allows)
                if (coins[i-1] <= j) {
                    dp[i][j] += dp[i][j - coins[i-1]];
                }
            }
        }

        return dp[n][amount];
    }
}
