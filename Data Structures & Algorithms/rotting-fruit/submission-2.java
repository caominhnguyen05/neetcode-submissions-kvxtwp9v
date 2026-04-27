class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        int freshFruits = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshFruits++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        if (freshFruits == 0) return 0;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int minutes = 0; 

        while (!queue.isEmpty() && freshFruits > 0) {
            int length = queue.size();

            for (int i = 0; i < length; i++) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                for (int[] dir : directions) {
                    int nextRow = row + dir[0];
                    int nextCol = col + dir[1];
                    if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n) {
                        if (grid[nextRow][nextCol] == 1) {
                            // This fruit becomes rotten
                            grid[nextRow][nextCol] = 2;
                            freshFruits--;
                            queue.add(new int[]{nextRow, nextCol});
                        }
                    }
                }
            }
            
            minutes++;
        }

        return freshFruits != 0 ? -1 : minutes;
    }

    // Time complexity: O(m*n)
    // Space complexity: O(m*n)
}
