class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        if (n == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int prev2 = 1; // dp[i-2]
        int prev1 = 1; // dp[i-1]

        for (int i = 2; i <= n; i++) {
            char current = s.charAt(i-1);
            char prev = s.charAt(i-2);

            int numWays = 0;

            if (current != '0') {
                numWays += prev1;
            }

            if ((prev == '1') || (prev == '2' && current <= '6')) {
                numWays += prev2;
            }

            prev2 = prev1;
            prev1 = numWays;
        }

        return prev1;
    }
}
