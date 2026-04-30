class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Convert list to set for O(1) lookup
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();

        // dp[i] = true if substring s[0..i] can be segmented
        boolean[] dp = new boolean[n];

        // Iterate over all substring end positions
        for (int end = 0; end < n; end++) {
            // Try all possible partition points
            for (int start = 0; start <= end; start++) {
                String thisSubstring = s.substring(start, end + 1);

                // If left part is valid and right part exists in dictionary
                if (wordSet.contains(thisSubstring) && (start == 0 || dp[start-1])) {
                    dp[end] = true;
                    break;
                }
            }
        }

        return dp[n-1];
    }
}
