class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 0, 0, candidates, target);

        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> curr, int start, int currSum, int[] candidates, int target) {
        if (currSum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates when they appear as siblings (same recursion level)
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }

            if (currSum + candidates[i] > target) {
                break;
            }

            curr.add(candidates[i]);
            backtrack(result, curr, i + 1, currSum + candidates[i], candidates, target);
            curr.remove(curr.size() - 1);
        }
    }
}
