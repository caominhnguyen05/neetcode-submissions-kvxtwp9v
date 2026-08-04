class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        // Add virtual balloons with value 1 at both ends.
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n+1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i+1] = nums[i];
        }

        // dp[left][right] = maximum coins obtained by bursting
        // all balloons strictly between left and right
        int[][] dp = new int[n + 2][n + 2];

        // Length is the distance between left and right
        // We start from 2 because length = 2 means no balloons inside
        for (int len = 2; len <= n + 1; len++) {
            // Try every interval [left, right]
            for (int left = 0; left + len <= n + 1; left++) {
                int right = left + len;

                // Choose the last balloon to burst
                for (int k = left + 1; k < right; k++) {
                    dp[left][right] = Math.max(
                        dp[left][right],
                        dp[left][k] + dp[k][right] + arr[left] * arr[k] * arr[right]
                    );
                }
            }
        }

        return dp[0][n+1];
    }
}
