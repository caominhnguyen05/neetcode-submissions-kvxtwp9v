class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        // visited[i] = whether point i is already included in the MST
        boolean[] visited = new boolean[n];
        
        // dist[i] = shortest known distance from the current MST to point i
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        int node = 0;
        int edges = 0;
        int minCost = 0;

        // Prim's algorithm: add the cheapest edge connecting a new point each time
        while (edges < n - 1) {
            visited[node] = true;
            int nextNode = -1;

            // For every unvisited point i, compute cost to connect i from the current node
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int currDist = Math.abs(points[node][0] - points[i][0])
                        + Math.abs(points[node][1] - points[i][1]);
                    dist[i] = Math.min(dist[i], currDist);

                    // Select the next point with the minimum cost
                    if (nextNode == -1 || dist[i] < dist[nextNode]) {
                        nextNode = i;
                    }
                }
            }

            // Add the cheaprst connection to the MST
            minCost += dist[nextNode];
            node = nextNode;
            edges++;
        }

        return minCost;
    }
}
