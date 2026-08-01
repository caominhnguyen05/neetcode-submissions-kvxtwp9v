class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int prev2 = 1; // number of ways to decode the first (i-2) characters
        int prev1 = 1; // number of ways to decode the first (i-1) characters

        for (int i = 2; i <= n; i++) {
            char curr = s.charAt(i-1);
            char prev = s.charAt(i-2);
            int numWays = 0;

            if (curr != '0') {
                numWays += prev1;
            }

            if (prev == '1' || (prev == '2' && curr <= '6')) {
                numWays += prev2;
            }
            
            prev2 = prev1;
            prev1 = numWays;
        }

        return prev1;
    }
}
