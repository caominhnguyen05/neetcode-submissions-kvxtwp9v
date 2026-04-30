class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int halfSum = sum / 2;
        int n = nums.length;

        // dp[i][j] = true if we can form sum j using the first i elements
        boolean[][] dp = new boolean[n + 1][halfSum + 1];

        // Base case, sum 0 is always achievable
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int currSum = 1; currSum <= halfSum; currSum++) {
            for (int i = 1; i <= n; i++) {
                // Option 1: exclude current number
                dp[i][currSum] = dp[i-1][currSum];

                // Option 2: include current number (if possible)
                if (currSum >= nums[i-1]) {
                    if (dp[i-1][currSum - nums[i-1]]) {
                        dp[i][currSum] = true;
                    }
                }
            }
        }

        return dp[n][halfSum];
    }
}
