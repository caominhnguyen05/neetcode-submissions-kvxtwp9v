class Solution {
    public int swimInWater(int[][] grid) {
        // Problem: Find a path from (0,0) to (n-1, n-1) that minimizes
        // the maximum cell height along the path
        // -> Dijkstra if we define: cost to reach each cell = smallest possible "maximum height so far"
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        // pq stores {timeSoFar, row, col}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int time = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (row == n-1 && col == n-1) {
                return time;
            }

            for (int[] dir : directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    minHeap.offer(new int[]{Math.max(time, grid[nr][nc]), nr, nc});
                }
            }
        }

        return n * n;
    }

    // Time: O(n^2 log n)
    // Space: O(n^2)
}
