class Solution {
    public int maxSubArray(int[] nums) {
        int currMax = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            currMax = Math.max(currMax + num, num);
            res = Math.max(res, currMax);
        }

        return res;
    }
}
