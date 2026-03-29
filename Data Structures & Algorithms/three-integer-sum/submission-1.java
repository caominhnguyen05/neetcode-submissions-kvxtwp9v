class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i <= n - 3; i++) {
            if (nums[i] > 0) break;
            // Skip duplicate values for the first element to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i-1]) continue;

            // Use 2 pointers to find pairs such that sum = 0
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Found a triplet
                    result.add(List.of(nums[i], nums[left], nums[right]));

                    // Move both pointers inward
                    left++;
                    right--;

                    // Skip duplicates for the second element
                    while (left < right && nums[left] == nums[left-1]) {
                        left++;
                    }

                    // Skip duplicates for the third element
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else { 
                    right--;
                }
            }
        }

        return result;
    }
}
