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
        List<int[]> times = new ArrayList<>();

        for (Interval interval : intervals) {
            times.add(new int[]{interval.start, 0});
            times.add(new int[]{interval.end, 1});
        }

        times.sort((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]); // Prioritise end time
            }
            return Integer.compare(a[0], b[0]);
        });

        int maxRooms = 0; // maximum number of rooms needed at one point
        int currRooms = 0;

        for (int i = 0; i < times.size(); i++) {
            // If start time, use 1 more room
            if (times.get(i)[1] == 0) {
                currRooms++;
                maxRooms = Math.max(maxRooms, currRooms);
            } else {
                currRooms--;
            }
        }

        return maxRooms;
    }
}
