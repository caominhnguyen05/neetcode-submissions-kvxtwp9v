class Solution {
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m;
    private int n;
    private final int INF = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int distance = 1;

        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                for (int[] dir : directions) {
                    int nextRow = row + dir[0];
                    int nextCol = col + dir[1];

                    if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n) {
                        if (grid[nextRow][nextCol] == INF) {
                            grid[nextRow][nextCol] = distance;
                            queue.add(new int[]{nextRow, nextCol});
                        }
                    }
                }
            }
            distance++; // move to next layer
        }

    }

}
