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
        // Each event is [time, type]
        // start time: type = 1
        // end time: type = -1
        List<int[]> events = new ArrayList<>();

        for (Interval interval : intervals) {
            events.add(new int[]{interval.start, 1});
            events.add(new int[]{interval.end, -1});
        }

        events.sort((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int activeRooms = 0;
        int maxRooms = 0;

        for (int[] event : events) {
            if (event[1] == 1) {
                activeRooms++;
                maxRooms = Math.max(maxRooms, activeRooms);
            } else {
                activeRooms--;
            }
        }

        return maxRooms;
    }

    // Time complexity: O(n log n)
    // Space complexity: O(n)
}
