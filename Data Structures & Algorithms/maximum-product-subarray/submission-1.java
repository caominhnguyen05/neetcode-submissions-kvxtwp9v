class Solution {
    public int maxProduct(int[] nums) {
        int maxP = 1; // maximum product including this number
        int minP = 1; // minimum product including this number
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int maxTemp = maxP;
            int minTemp = minP;

            // Extend previous subarray or start a new one
            int currMax = Math.max(Math.max(maxP * nums[i], minP * nums[i]), nums[i]);
            ans = Math.max(currMax, ans);

            maxP = currMax;
            minP = Math.min(Math.min(maxTemp * nums[i], minTemp * nums[i]), nums[i]);
        }

        return ans;
    }
}
