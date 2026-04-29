class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if (n == 1) {
            return nums[0];
        }

        return Math.max(
            robHelper(nums, 0, n - 2),
            robHelper(nums, 1, n - 1)
        );
    }

    private int robHelper(int[] nums, int start, int end) {
        int prev1 = 0;
        int prev2 = 0;

        for (int i = start; i <= end; i++) {
            int currentProfit = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = currentProfit;
        }

        return prev1;
    }
}