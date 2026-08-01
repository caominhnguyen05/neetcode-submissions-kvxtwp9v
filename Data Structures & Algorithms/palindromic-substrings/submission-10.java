class Solution {
    public int countSubstrings(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd length palindromes
            res += countPalindromes(s, i, i);
            res += countPalindromes(s, i - 1, i);
        }

        return res;
    }

    private int countPalindromes(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }

        return count;
    }
}
