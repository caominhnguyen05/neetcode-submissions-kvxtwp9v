class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];

        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0; // start from point 0

        int totalCost = 0;

        for (int i = 0; i < n; i++) {
            // Find the unvisited point with the smallest connection cost
            int curr = -1;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && (curr == -1 || minDist[j] < minDist[curr])) {
                    curr = j;
                }
            }

            // Add this point to the MST
            visited[curr] = true;
            totalCost += minDist[curr];

            // Update the minimum cost to connect every remaining point
            for (int next = 0; next < n; next++) {
                if (!visited[next]) {
                    int dist = Math.abs(points[curr][0] - points[next][0]) + 
                        Math.abs(points[curr][1] - points[next][1]);
                    if (dist < minDist[next]) {
                        minDist[next] = dist;
                    }
                }
            }
        }

        return totalCost;
    }
}
