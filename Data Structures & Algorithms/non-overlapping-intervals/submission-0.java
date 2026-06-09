class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort intervals by ascending end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int prevEnd = intervals[0][1];
        int count = 1; // max number of non-overlapping intervals

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prevEnd) {
                count++;
                prevEnd = intervals[i][1];
            }
        }

        return intervals.length - count;
    }
}
