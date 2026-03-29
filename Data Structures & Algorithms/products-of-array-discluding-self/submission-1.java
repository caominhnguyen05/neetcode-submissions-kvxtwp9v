class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Calculate product of all elements to the right of each index
        result[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            result[i] = result[i+1] * nums[i+1];
        }

        // Multiply by with products of elements to the left
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            result[i] = result[i] * prefix;
            prefix *= nums[i];
        }

        return result;
    }
}  
