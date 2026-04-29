class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        // dp[i][j] = true if the substring s[i..j] is a palindrome
        boolean[][] dp = new boolean[n][n];
        int startIndex = 0;
        int maxLen = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;

                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        startIndex = i;
                    }
                }
            }
        }

        return s.substring(startIndex, startIndex + maxLen);
    }
}
