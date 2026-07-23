class Solution {
    private static final int INF = 2147483647;
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m;
    private int n;

    public void islandsAndTreasure(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // Multi-source BFS from all treasure chest cells
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int distance = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];

                for (int[] dir : directions) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == INF && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        grid[nr][nc] = distance;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
            distance++;
        }
    }
}
