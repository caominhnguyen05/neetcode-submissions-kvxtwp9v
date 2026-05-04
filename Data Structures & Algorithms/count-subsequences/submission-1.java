class Solution {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }

        int m = s.length();
        int n = t.length();

        // dp[i][j] = number of distinct subsequences of s[0..i)
        // which are equal to t[0..j)
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            if (s.charAt(i-1) == t.charAt(0)) {
                dp[i][1] = 1 + dp[i-1][1];
            } else {
                dp[i][1] = dp[i-1][1];
            }
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j] + dp[i - 1][j-1];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[m][n];
    }
}
