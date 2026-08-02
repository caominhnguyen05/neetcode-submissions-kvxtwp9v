class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        // Problem: Whether we can find a subset with a sum of sum/2

        int n = nums.length;

        // dp[i][j] = whether using the first i numbers we can make sum j
        boolean[][] dp = new boolean[n + 1][sum / 2 + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            int num = nums[i-1];

            for (int j = 0; j <= sum / 2; j++) {
                // Don't take
                dp[i][j] = dp[i-1][j];

                // Take
                if (j >= num) {
                    dp[i][j] = dp[i][j] | dp[i-1][j - num];
                }
            }
        }

        return dp[n][sum / 2];
    }
}
