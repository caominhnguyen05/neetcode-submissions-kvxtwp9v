class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int edgesUsed = 0;
        int res = 0;

        // Min distance from MST to each node
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];

        int currNode = 0;

        while (edgesUsed < n - 1) {
            visited[currNode] = true;
            int nextNode = -1;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int currDistance = Math.abs(points[currNode][0] - points[i][0]) + Math.abs(points[currNode][1] - points[i][1]);
                    minDist[i] = Math.min(currDistance, minDist[i]);

                    // Choose this node to add to MST next
                    if (nextNode == -1 || minDist[i] < minDist[nextNode]) {
                        nextNode = i;
                    }
                }
            }

            res += minDist[nextNode];
            currNode = nextNode;
            edgesUsed++;
        }

        return res;
    }
}
