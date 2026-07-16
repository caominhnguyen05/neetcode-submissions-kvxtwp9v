class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        int maxFrequency = 0;
        
        for (char task : tasks) {
            counts[task - 'A']++;
            maxFrequency = Math.max(maxFrequency, counts[task - 'A']);
        }

        int maxFrequencyTaskCount = 0;

        for (int i = 0; i < 26; i++) {
            if (counts[i] == maxFrequency) {
                maxFrequencyTaskCount++;
            }
        }

        int minimumIntervals = (n + 1) * (maxFrequency - 1) + maxFrequencyTaskCount;

        return Math.max(minimumIntervals, tasks.length);
    }

    // Time: O(m)
    // Space: O(1)
}
