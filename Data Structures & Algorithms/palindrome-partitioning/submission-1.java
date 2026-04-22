class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();

        // Use DP to precompute palindromic substrings
        // dp[i][j] = whether s[i..j] is palindrome
        boolean[][] dp = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
        }

        for (int length = 3; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int end = i + length - 1;
                dp[i][end] = dp[i+1][end-1] && s.charAt(i) == s.charAt(end);
            }
        }

        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), 0, dp, s);
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> curr, int startIndex, boolean[][] dp, String s) {
        if (startIndex == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int endIndex = startIndex; endIndex < s.length(); endIndex++) {
            if (dp[startIndex][endIndex]) {
                curr.add(s.substring(startIndex, endIndex + 1));
                backtrack(res, curr, endIndex + 1, dp, s);
                curr.remove(curr.size() - 1);
            }
        }
    }
}