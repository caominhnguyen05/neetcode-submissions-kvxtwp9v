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

        // dp[j] = number of ways to form sum j
        int[] dp = new int[positiveSum + 1];

        // Base case: one way to make sum 0
        dp[0] = 1;

        for (int num : nums) {
            for (int j = positiveSum; j >= num; j--) {
                dp[j] += dp[j-num];
            }
        }

        return dp[positiveSum];
    }
}
