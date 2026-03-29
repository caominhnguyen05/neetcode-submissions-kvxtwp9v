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
        // Min heap approach
        // intervals.sort((a, b) -> a.start - b.start);

        // PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // for (Interval interval : intervals) {
        //     if (!minHeap.isEmpty() && minHeap.peek() <= interval.start) {
        //         // We can reuse this room
        //         minHeap.poll();
        //     }

        //     minHeap.offer(interval.end);
        // }

        // return minHeap.size();

        List<int[]> time = new ArrayList<>();
        for (Interval i : intervals) {
            time.add(new int[]{i.start, 1});
            time.add(new int[]{i.end, -1});
        }

        time.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int maxRooms = 0;
        int currRooms = 0;

        for (int[] t : time) {
            currRooms += t[1];
            maxRooms = Math.max(maxRooms, currRooms);
        }

        return maxRooms;
    }
}
