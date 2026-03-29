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
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Sort intervals by start time ascending
        intervals.sort((a, b) -> a.start - b.start);

        int prevEnd = -1;
        for (Interval interval : intervals) {
            if (interval.start < prevEnd) {
                return false;
            }
            prevEnd = interval.end;
        }

        return true;
    }
}
