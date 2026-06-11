class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        if (target > totalSum || target < -totalSum) return 0;
        if ((target + totalSum) % 2 == 1) {
            return 0;
        }

        int positiveSum = (target + totalSum) / 2;

        // dp[i][j] = number of ways to form sum j using the first i numbers
        int[][] dp = new int[n + 1][positiveSum + 1];
        
        // Base case: sum 0 is always achievable
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int currSum = 0; currSum <= positiveSum; currSum++) {
                // not take nums[i-1]
                dp[i][currSum] = dp[i-1][currSum];

                // take nums[i-1];
                if (currSum >= nums[i-1]) {
                    dp[i][currSum] += dp[i-1][currSum - nums[i-1]];
                }
            }
        }

        return dp[n][positiveSum];
    }
}
