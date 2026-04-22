class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder curr, int numOpen, int numClose, int n) {
        if (numOpen + numClose == n * 2) {
            res.add(curr.toString());
            return;
        }

        if (numOpen < n) {
            curr.append('(');
            backtrack(res, curr, numOpen + 1, numClose, n);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (numOpen > numClose) {
            curr.append(')');
            backtrack(res, curr, numOpen, numClose + 1, n);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
