class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m < n) {
            return 0;
        }

        // dp[i][j] = number of ways to form t[0..j-1]
        // using characters from s[0..i-1]
        int[][] dp = new int[m + 1][n + 1];

        // Base case:
        // An empty target "" can always be formed from any prefix of s
        // by choosing no characters
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Case 1: do not use s[i-1]
                // We skip current character of s
                dp[i][j] = dp[i-1][j];

                // Case 2: Use s[i-1] if it matches t[j-1]
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }

        return dp[m][n];
    }
}
