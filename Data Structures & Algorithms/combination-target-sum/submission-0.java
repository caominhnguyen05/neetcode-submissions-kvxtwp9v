class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), 0, 0, nums, target);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> curr, int start, int currSum, int[] nums, int target) {
        if (currSum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (currSum + nums[i] <= target) {
                curr.add(nums[i]);
                backtrack(result, curr, i, currSum + nums[i], nums, target);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
