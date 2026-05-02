class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[] dp = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int prevDiagonal = 0; // dp[i-1][j-1]
            for (int j = 1; j <= n; j++) {
                int temp = dp[j]; // store dp[i-1][j]

                if (text1.charAt(i - 1) == text2.charAt(j-1)) {
                    dp[j] = prevDiagonal + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j-1]);
                }

                prevDiagonal = temp; // move diagonal forward
            }
        }

        return dp[n];
    }
}
