class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : nums) {
            // Extend the current subarray or start a new one
            currSum = Math.max(currSum + num, num);
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }
}
