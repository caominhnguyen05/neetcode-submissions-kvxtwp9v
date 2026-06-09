class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Integer[] queryIndices = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            queryIndices[i] = i;
        }

        Arrays.sort(queryIndices, (a, b) -> Integer.compare(queries[a], queries[b]));

        // [intervalLength, intervalEnd]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int[] ans = new int[queries.length];

        int intervalIndex = 0;

        for (int queryIndex : queryIndices) {
            int query = queries[queryIndex];

            // Add every interval whose start <= query
            while (intervalIndex < intervals.length && intervals[intervalIndex][0] <= query) {
                int start = intervals[intervalIndex][0];
                int end = intervals[intervalIndex][1];

                int length = end - start + 1;
                minHeap.offer(new int[]{length, end});
                intervalIndex++;
            }

            // Remove intervals that no longer contains query
            while (!minHeap.isEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll();
            }

            ans[queryIndex] = minHeap.isEmpty() ? -1 : minHeap.peek()[0];
        }

        return ans;
    }
}
