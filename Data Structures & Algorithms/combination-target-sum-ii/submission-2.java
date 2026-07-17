class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        
        backtrack(res, new ArrayList<>(), 0, 0, candidates, target);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> curr,
        int currSum, int i, int[] candidates, int target) {
        if (currSum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            // skip duplicate choices at the same recursion level
            if (j > i && candidates[j] == candidates[j-1]) {
                continue;
            }

            if (currSum + candidates[j] > target) {
                break;
            }

            curr.add(candidates[j]);
            backtrack(res, curr, currSum + candidates[j], j + 1, candidates, target);
            curr.remove(curr.size() - 1);
        }
    }
}
