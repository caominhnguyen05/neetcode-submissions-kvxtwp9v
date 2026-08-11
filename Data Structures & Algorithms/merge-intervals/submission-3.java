class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort intervals in ascending start times
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // This interval does not overlap with the previous one
            if (intervals[i][0] > prevEnd) {
                merged.add(new int[]{prevStart, prevEnd});
                prevStart = intervals[i][0];
                prevEnd = intervals[i][1];
            } else {
                prevEnd = Math.max(intervals[i][1], prevEnd);
            }
        }

        // Add the last interval
        merged.add(new int[]{prevStart, prevEnd});

        int[][] res = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            res[i] = merged.get(i);
        }

        return res;
    }
}
