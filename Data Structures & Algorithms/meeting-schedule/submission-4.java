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
        if (intervals.size() == 0) {
            return true;
        }

        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        int prevEnd = -1;

        for (int i = 0; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (curr.start < prevEnd) {
                return false;
            }
            prevEnd = curr.end;
        }

        return true;
    }
}
