class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int currMin = 1;
        int currMax = 1;

        for (int num : nums) {
            int temp = currMax * num;

            currMax = Math.max(Math.max(currMax * num, currMin * num), num);
            currMin = Math.min(Math.min(temp, currMin * num), num);
            res = Math.max(res, currMax);
        }

        return res;
    }
}
