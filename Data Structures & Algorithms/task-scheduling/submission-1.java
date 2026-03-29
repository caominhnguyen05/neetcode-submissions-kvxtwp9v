class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Frequency of each task (A - Z)
        int[] frequency = new int[26];
        int maxFrequency = 0;

        // Count frequencies of each task
        for (char c : tasks) {
            frequency[c - 'A']++;
            maxFrequency = Math.max(maxFrequency, frequency[c - 'A']);
        }

        // Count how many tasks have the maximum frequency
        int maxFrequencyTaskCount = 0;
        for (int freq : frequency) {
            if (freq == maxFrequency) {
                maxFrequencyTaskCount++;
            }
        }

        int minimumIntervals = (maxFrequency - 1) * (n + 1) + maxFrequencyTaskCount;

        return Math.max(minimumIntervals, tasks.length);
    }
}
