class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int edgesUsed = 0;
        int res = 0;

        // Min distance from MST to each node
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        // True = node is already in MST
        boolean[] visited = new boolean[n];

        int currNode = 0;

        // Keep adding edges until MST has n-1 edges
        while (edgesUsed < n - 1) {
            visited[currNode] = true; // Add current node to MST
            int nextNode = -1;        // hold the cheapest unvisited node to add next

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int currDistance = Math.abs(points[currNode][0] - points[i][0]) + Math.abs(points[currNode][1] - points[i][1]);

                    // if currNode offers a shorter path to i than previously known, update it
                    minDist[i] = Math.min(currDistance, minDist[i]);

                    // Track the unvisited node with the globally smallest minDist
                    if (nextNode == -1 || minDist[i] < minDist[nextNode]) {
                        nextNode = i;
                    }
                }
            }

            // Add the cheapest edge to our result
            res += minDist[nextNode];
            currNode = nextNode;
            edgesUsed++;
        }

        return res;
    }
}
