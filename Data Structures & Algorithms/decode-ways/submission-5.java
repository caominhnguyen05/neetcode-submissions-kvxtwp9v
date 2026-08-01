class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        // dp[i] = number of ways to decode the first i characters
        int[] dp = new int[n + 1];
        dp[0] = 1; // 1 way to decode an empty string
        dp[1] = 1; // first character is not 0

        for (int i = 2; i <= n; i++) {
            char curr = s.charAt(i-1);
            char prev = s.charAt(i-2);

            if (curr != '0') {
                dp[i] += dp[i-1];
            }

            if ((prev == '1') || (prev == '2' && curr <= '6')) {
                dp[i] += dp[i-2];
            }
        }

        return dp[n];
    }
}
