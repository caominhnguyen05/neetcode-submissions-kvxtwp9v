class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            count += expandFromCenter(s, i, i);
            count += expandFromCenter(s, i, i + 1);
        }

        return count;
    }

    private int expandFromCenter(String s, int left, int right) {
        int palindromes = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            palindromes++;
            left--;
            right++;
        }

        return palindromes;
    }
}
