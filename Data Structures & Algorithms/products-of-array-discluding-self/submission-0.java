class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Calculate product of numbers on the right of each index
        result[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            result[i] = result[i+1] * nums[i+1];
        }

        int prefix = 1;
        for (int i = 0; i < n; i++) {
            result[i] = result[i] * prefix;
            prefix *= nums[i];
        }

        return result;
    }
}  
