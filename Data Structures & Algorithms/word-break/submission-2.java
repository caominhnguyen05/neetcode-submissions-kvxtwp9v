class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();

        // dp[i] = true if s[0..i] can be segmented
        boolean[] dp = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String thisString = s.substring(j, i + 1);
                
                if (wordSet.contains(thisString) && (j == 0 || dp[j-1])) {
                    dp[i] = true;
                }
            }
        }

        return dp[n-1];
    }
}
