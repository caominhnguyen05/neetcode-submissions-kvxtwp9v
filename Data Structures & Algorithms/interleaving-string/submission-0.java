class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty()) {
            return true;
        }

        int m = s1.length();
        int n = s2.length();

        // dp[i][j] = true if we can form the first (i + j) chars of s3
        // using first i chars of s1 and first j chars of s2
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        dp[0][0] = true;

        // First column
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }

        // First row
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c = s3.charAt(i + j - 1);

                if (s1.charAt(i-1) == c) {
                    dp[i][j] |= dp[i-1][j];
                }

                if (s2.charAt(j-1) == c) {
                    dp[i][j] |= dp[i][j-1];
                }
            }
        }

        return dp[m][n];
    }
}
