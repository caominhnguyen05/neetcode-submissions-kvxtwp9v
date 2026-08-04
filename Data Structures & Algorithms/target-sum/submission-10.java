class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Impossible to reach target
        if (Math.abs(target) > totalSum) {
            return 0;
        }

        // (target + totalSum) must be even
        if ((target + totalSum) % 2 == 1) {
            return 0;
        }

        // Problem: How many subsets have sum = (target + totalSum) / 2
        int subsetSum = (target + totalSum) / 2;
        int n = nums.length;

        // dp[i][j] = ways to make sum j using first i numbers
        int[][] dp = new int[n + 1][subsetSum + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            int num = nums[i-1];

            for (int j = 0; j <= subsetSum; j++) {
                // Don't take current number
                dp[i][j] = dp[i-1][j];

                // Take current number
                if (j >= num) {
                    dp[i][j] += dp[i-1][j - num];
                }
            }
        }

        return dp[n][subsetSum];
    }
}
