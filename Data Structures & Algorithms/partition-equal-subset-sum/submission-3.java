class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        // Check if their exists a subset with sum of sum / 2
        int target = sum / 2;
        int n = nums.length;
        
        // dp[i][j] = true if we can make sum j using the first i numbers
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                // Don't take this number
                dp[i][j] = dp[i-1][j];

                // Take this number
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] | dp[i-1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][target];
    }
}
