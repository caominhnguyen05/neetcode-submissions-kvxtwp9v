class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();

        // dp[i] = true if substring s[0..i] can be segmented
        boolean[] dp = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int start = i; start >= 0; start--) {
                String thisSubstring = s.substring(start, i + 1);

                if (wordSet.contains(thisSubstring) && (start == 0 || dp[start-1])) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n-1];
    }
}
