class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        // dp[i] = length of longest increasing subsequence ending at index i
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;

        for (int i = 1; i < n; i++) {
            int num = nums[i];

            for (int j = 0; j < i; j++) {
                if (nums[j] < num) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(res, dp[i]);
            }
        }

        return res;
    }

    // Time: O(n^2)
    // Space: O(n)
}
