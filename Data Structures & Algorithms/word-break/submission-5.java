class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        // dp[i] = true if s[0..i] can be segmented
        boolean[] dp = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (String word : wordDict) {
                int len = word.length();

                if (i + 1 < len) continue;

                int start = i + 1 - len;

                if (s.substring(start, i + 1).equals(word) && 
                    (start == 0 || dp[start - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n-1];
    }

    // Time: O(n * m * t)
    // Space: O(n)
    // n is the length of stirng s, m is the number of words,
    // t is the maximum length of any word in wordDict
}
