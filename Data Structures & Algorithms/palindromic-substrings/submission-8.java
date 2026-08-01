class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            // Find palindromes with odd length
            int left = i;
            int right = i;

            while (left >= 0 && right <= n - 1) {
                if (s.charAt(left) == s.charAt(right)) {
                    count++;
                    left--;
                    right++;
                } else {
                    break;
                }
            }

            // Find palindromes with even length
            left = i - 1;
            right = i;

            while (left >= 0 && right <= n - 1) {
                if (s.charAt(left) == s.charAt(right)) {
                    count++;
                    left--;
                    right++;
                } else {
                    break;
                }
            }
        }

        return count;
    }

    // Time: O(n^2)
    // Space: O(1)
}
