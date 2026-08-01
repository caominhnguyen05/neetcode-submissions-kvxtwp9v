class Solution {
    public int rob(int[] nums) {
        // We can rob house 0 to house (n-2) or house 1 to house (n-1)
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        return Math.max(robHelper(nums, 0, n-2), robHelper(nums, 1, n-1));
    }

    private int robHelper(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {
            int curr = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
