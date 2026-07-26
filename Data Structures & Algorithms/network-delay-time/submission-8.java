class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            int from = time[0];
            if (!graph.containsKey(from)) {
                graph.put(from, new ArrayList<>());
            }

            graph.get(from).add(new int[]{time[1], time[2]});
        }

        // dist[i] = shortest known distance from start node k to node i
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Min heap (distance, node)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0, k});

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int currDist = curr[0];
            int currNode = curr[1];

            // Ignore this path if we found a better path
            if (currDist > dist[currNode]) {
                continue;
            }

            // If this node has no neighbor, continue
            if (!graph.containsKey(currNode)) {
                continue;
            }

            for (int[] neighbor : graph.get(currNode)) {
                int next = neighbor[0];
                int distToNeighbor = neighbor[1];

                if (currDist + distToNeighbor < dist[next]) {
                    dist[next] = currDist + distToNeighbor;
                    minHeap.offer(new int[]{dist[next], next});
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            // If we cannot reach this node from k, return -1
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}
