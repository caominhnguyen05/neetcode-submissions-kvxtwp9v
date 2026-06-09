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
        // Each event is: [time, type]
        // type = 1 -> start of meeting (needs room)
        // type = -1 -> end of meeting (releases room)
        List<int[]> events = new ArrayList<>();

        for (Interval interval : intervals) {
            events.add(new int[]{interval.start, 1});
            events.add(new int[]{interval.end, -1});
        }

        // Sort by time
        // If same time: process end before start (free room first)
        events.sort((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int activeMeetings = 0;
        int maxRoomsNeeded = 0;

        for (int i = 0; i < events.size(); i++) {
            if (events.get(i)[1] == 1) {
                activeMeetings++;
                maxRoomsNeeded = Math.max(maxRoomsNeeded, activeMeetings);
            } else {
                activeMeetings--;
            }
        }

        return maxRoomsNeeded;
    }
}
