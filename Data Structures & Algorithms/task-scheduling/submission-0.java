class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> counts = new HashMap<>();
        int maxFrequency = 1;

        for (char c : tasks) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
            maxFrequency = Math.max(maxFrequency, counts.get(c));
        }

        // Count how many tasks have max frequency
        int haveMax = 0;
        for (char c : counts.keySet()) {
            if (counts.get(c) == maxFrequency) {
                haveMax++;
            }
        }

        int ans = (maxFrequency - 1) * (n + 1) + haveMax;

        return Math.max(ans, tasks.length);
    }
}
