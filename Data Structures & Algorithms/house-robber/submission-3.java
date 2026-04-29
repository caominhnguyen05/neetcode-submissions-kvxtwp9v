class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        // prev2 = max amount of money we can rob at house (i-2)
        // prev1 = max amount of money we can rob at house (i-1)
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int curr = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
