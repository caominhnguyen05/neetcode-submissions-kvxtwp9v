class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();

        // Use DP to precompute palindromic substrings
        // dp[i][j] = whether s[i..j] is palindrome
        boolean[][] dp = new boolean[n][n];
        
        for (int start = n - 1; start >= 0; start--) {
            for (int end = start; end < n; end++) {
                if (s.charAt(start) == s.charAt(end)) {
                    if (end - start <= 2) {
                        dp[start][end] = true;
                    } else {
                        dp[start][end] = dp[start+1][end-1];
                    }
                }
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