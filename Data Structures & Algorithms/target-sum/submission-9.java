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

        int[] dp = new int[subsetSum + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int s = subsetSum; s >= num; s--) {
                dp[s] += dp[s - num];
            }
        }

        return dp[subsetSum];
    }
}
