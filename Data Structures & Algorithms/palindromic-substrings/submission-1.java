class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        // dp[i][j] = true if substring s[i..j] is a palindrome
        boolean[][] dp = new boolean[n][n];
        int ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }

        return ans;
    }
}
