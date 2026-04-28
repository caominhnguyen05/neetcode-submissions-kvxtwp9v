class Solution {
    public int minCostConnectPoints(int[][] points) {
        // Prim's algorithm
        int n = points.length;
        Set<Integer> visited = new HashSet<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0, 0});
        int res = 0;

        while (visited.size() < n) {
            int[] curr = minHeap.poll();
            int dist = curr[0];
            int index = curr[1];

            if (visited.contains(index)) continue;
            visited.add(index);
            res += dist;
            
            int x = points[index][0];
            int y = points[index][1];

            for (int j = 0; j < n; j++) {
                if (!visited.contains(j)) {
                    int distanceToNeighbor = Math.abs(x - points[j][0]) + Math.abs(y - points[j][1]);
                    minHeap.offer(new int[]{distanceToNeighbor, j});
                }
            }
        }

        return res;

    }
}
