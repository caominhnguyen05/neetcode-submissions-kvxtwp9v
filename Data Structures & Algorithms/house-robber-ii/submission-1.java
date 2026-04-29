class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int n = nums.length;

        int first = houseRobber(nums, 0, n-2);
        int second = houseRobber(nums, 1, n-1);

        return Math.max(first, second);
    }

    private int houseRobber(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int prev2 = nums[start];
        int prev1 = Math.max(nums[start], nums[start+1]);

        for (int i = start + 2; i <= end; i++) {
            int curr = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
