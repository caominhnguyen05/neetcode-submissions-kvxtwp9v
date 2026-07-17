class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), 0, 0, nums, target);
        return res;
    }

    private void backtrack(
        List<List<Integer>> res, List<Integer> curr, int currSum, int i, int[] nums, int target) {
        if (currSum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (currSum + nums[j] <= target) {
                curr.add(nums[j]);
                backtrack(res, curr, currSum + nums[j], j, nums, target);
                curr.remove(curr.size() - 1);
            }
        }
    }

    // Time: O(2^(t/m))
    // Space: O(t/m)
    // t is the given target and m is the minimum value in nums.
}
