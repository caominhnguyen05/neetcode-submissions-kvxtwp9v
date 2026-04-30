class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i] = min number of coins to make up amount i
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;

            for (int coin : coins) {
                if (coin > i || dp[i-coin] == Integer.MAX_VALUE) {
                    continue;
                } 
                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
