class Solution {
    private final int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int left = Integer.MAX_VALUE;
        int right = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                left = Math.min(left, grid[i][j]);
                right = Math.max(right, grid[i][j]);
            }
        }

        int ans = 0;

        // Binary search on the solution space
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canSwim(mid, grid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    // Check if we can reach last cell - perform BFS on cells with elevation of at most t
    private boolean canSwim(int t, int[][] grid) {
        if (grid[0][0] > t) {
            return false;
        }
        
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            // Last cell can be reached
            if (row == n - 1 && col == n-1) {
                return true;
            }

            for (int[] dir : directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                if (0 <= nr && nr < n && 0 <= nc && nc < n && !visited[nr][nc]) {
                    if (grid[nr][nc] <= t) {
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }

        return false;
    }
}