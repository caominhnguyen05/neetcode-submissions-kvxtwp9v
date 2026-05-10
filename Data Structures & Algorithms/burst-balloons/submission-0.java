class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[arr.length - 1] = 1;
        for (int i = 1; i <= n; i++) {
            arr[i] = nums[i-1];
        }

        // dp[l][r] = maximum coins from bursting all balloons strictly between l and r
        int[][] dp = new int[n + 2][n + 2];

        // length is the distance between l and r
        // length = 1 means no balloons between them, so dp[l][r] = 0
        for (int length = 2; length <= n + 1; length++) {
            for (int l = 0; l + length <= n + 1; l++) {
                int r = l + length;

                for (int k = l + 1; k < r; k++) {
                    int coins = dp[l][k] + arr[l] * arr[k] * arr[r] + dp[k][r];
                    dp[l][r] = Math.max(dp[l][r], coins);
                }
            }
        }

        return dp[0][n+1];
    }
}
