class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (target > sum || target < -sum) {
            return 0;
        }

        // dp[i][j] = number of ways to reach (j - sum) using the first i numbers
        int[][] dp = new int[n + 1][2 * sum + 1];

        // Base case: 0 numbers, sum 0 => 1 way
        dp[0][sum] = 1;
        
        for (int i = 1; i <= n; i++) {
            int num = nums[i-1];

            for (int j = 0; j <= 2 * sum; j++) {
                // If possible to reach this sum using previous numbers
                if (dp[i-1][j] != 0) {
                    int plus = j + num;
                    if (plus <= 2 * sum) {
                        dp[i][plus] += dp[i - 1][j];
                    }

                    int minus = j - num;
                    if (minus >= 0) {
                        dp[i][minus] += dp[i-1][j];
                    }
                }
            }
        }

        return dp[n][target + sum];
    }
}
