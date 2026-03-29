class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int left = 0;
        int maxLength = 0;
        int maxFrequency = 1; // most frequent character count inside current window

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            counts[c - 'A']++;

            maxFrequency = Math.max(maxFrequency, counts[c - 'A']);

            while (right - left + 1 - maxFrequency > k) {
                counts[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
