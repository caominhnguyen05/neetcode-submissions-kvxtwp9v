class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Create adjacency list
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for (int[] time : times) {
            adjList.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, k});

        Set<Integer> visited = new HashSet<>();
        int time = 0;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int distance = curr[0];
            int node = curr[1];
            
            if (visited.contains(node)) continue;
            visited.add(node);
            time = distance;

            if (adjList.containsKey(node)) {
                for (int[] neighbor : adjList.get(node)) {
                    int neighborNode = neighbor[0];
                    int distanceToNeighbor = neighbor[1];

                    if (!visited.contains(neighborNode)) {
                        minHeap.offer(new int[]{distance + distanceToNeighbor, neighborNode});
                    }
                }
            }
        }

        return visited.size() == n ? time : -1;
    }
}