class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        // dp[i][j] = true if s[i..j] is a palindrome
        boolean[][] dp = new boolean[n][n];
        int longest = 1;
        int start = 0;

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
            if (dp[i][i+1]) {
                longest = 2;
                start = i;
            }
        }

        for (int length = 3; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int endIndex = i + length - 1;
                dp[i][endIndex] = dp[i+1][endIndex-1] && s.charAt(i) == s.charAt(endIndex);

                if (dp[i][endIndex]) {
                    longest = length;
                    start = i;
                }
            }
        }

        return s.substring(start, start + longest);
    }
}
