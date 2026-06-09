class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort intervals by ascending start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();

        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > prevEnd) {
                merged.add(new int[]{prevStart, prevEnd});
                prevStart = intervals[i][0];
                prevEnd = intervals[i][1];
            } else {
                prevEnd = Math.max(prevEnd, intervals[i][1]);
            }
        }

        // Add last interval
        merged.add(new int[]{prevStart, prevEnd});

        int[][] ans = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            ans[i] = merged.get(i);
        }

        return ans;
    }
}
