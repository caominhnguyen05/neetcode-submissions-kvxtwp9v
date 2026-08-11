class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // Sort intervals by starting times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Store queries together with their original indices
        int[][] sortedQueries = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        // Process queries from smallest to largest
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[queries.length];
        int intervalIndex = 0;

        // Min heap:
        // [interval length, right endpoint]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int[] query : sortedQueries) {
            int q = query[0];
            int originalIndex = query[1];

            // Add every interval that has started by this query
            while (intervalIndex < intervals.length && intervals[intervalIndex][0] <= q) {
                int left = intervals[intervalIndex][0];
                int right = intervals[intervalIndex][1];

                int length = right - left + 1;

                minHeap.offer(new int[]{length, right});
                intervalIndex++;
            }

            // Remove intervals that already ended
            while (!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }

            // The heap top is the shortest interval containing q
            if (minHeap.isEmpty()) {
                result[originalIndex] = -1;
            } else {
                result[originalIndex] = minHeap.peek()[0];
            }
        }

        return result;
    }
}
