class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort by end time (greedy choice: finish earliest)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int kept = 1; // we always take the first interval
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= lastEnd) {
                kept++;
                lastEnd = intervals[i][1];
            }
        }

        return intervals.length - kept;
    }
}
