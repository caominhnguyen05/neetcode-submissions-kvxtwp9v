/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        // Find the maximum number of rooms needed at one time
        List<int[]> times = new ArrayList<>();

        for (Interval interval : intervals) {
            times.add(new int[]{interval.start, 1});
            times.add(new int[]{interval.end, 0});
        }

        // Sort the times in ascending order and prioritize end time over start time
        times.sort((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int currRooms = 0;
        int res = 0;

        for (int[] time : times) {
            if (time[1] == 1) {
                currRooms++;
                res = Math.max(res, currRooms);
            } else {
                currRooms--;
            }
        }

        return res;
    }

    // Time: O(n log n)
    // Space: O(n)
}
