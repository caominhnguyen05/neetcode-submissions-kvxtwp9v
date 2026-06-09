class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> newIntervals = new ArrayList<>();

        int n = intervals.length;
        int i = 0;

        // Add intervals before new interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            newIntervals.add(intervals[i]);
            i++;
        }

        // Add overlapping interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        newIntervals.add(newInterval);

        // Add remaining intervals
        while (i < n) {
            newIntervals.add(intervals[i]);
            i++;
        }

        int[][] ans = new int[newIntervals.size()][2];
        for (int j = 0; j < ans.length; j++) {
            ans[j] = newIntervals.get(j);
        }

        return ans;
    }
}
