class Solution {
    public int swimInWater(int[][] grid) {
        // Find a path that minimizes the maximum cell height along the path
        int n = grid.length;

        boolean[][] visited = new boolean[n][n];

        // Min heap ordered by the minimum water level required to reach a cell.
        // Each entry: {requiredTime, row, col}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int time = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (row == n - 1 && col == n - 1) {
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

        return -1;
    }
}
