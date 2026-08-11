class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort the intervals by ascending end times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int nonOverlapping = 1;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prevEnd) {
                nonOverlapping++;
                prevEnd = intervals[i][1];
            }
        }

        return intervals.length - nonOverlapping;
    }
}
