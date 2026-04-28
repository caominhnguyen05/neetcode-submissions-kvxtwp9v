class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        // dist[i] = shortest known time to reach node i
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Min heap (distance, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});

        Set<Integer> visited = new HashSet<>();
        visited.add(k);

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currDist = curr[0];
            int currNode = curr[1];

            // Ignore current path if we found a better one
            if (currDist > dist[currNode]) continue;

            // If this node has no neighbors
            if (!graph.containsKey(currNode)) continue;

            for (int[] neighbor : graph.get(currNode)) {
                int next = neighbor[0];
                int distToNeighbor = neighbor[1];

                // Add neighbor to heap if it creates a shorter path
                if (currDist + distToNeighbor < dist[next]) {
                    dist[next] = currDist + distToNeighbor;
                    pq.offer(new int[]{dist[next], next});
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}
