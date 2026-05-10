class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // dp[i][j] = whether s[i:] matches with p[j:]
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base case: two empty strings match
        dp[m][n] = true;

        for (int i = m; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                boolean match = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

                // If the next pattern character is * (a*)
                if ((j + 1) < n && p.charAt(j + 1) == '*') {
                    // Choice 1: Use zero occurrence of the current character
                    dp[i][j] = dp[i][j + 2];

                    // Choice 2: Use one or more occurrence of the current character
                    if (match) {
                        dp[i][j] = dp[i][j] | dp[i+1][j];
                    }
                } else if (match) {
                    dp[i][j] = dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}