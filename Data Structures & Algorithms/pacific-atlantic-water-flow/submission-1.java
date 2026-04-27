class Solution {
    private int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int m;
    private int n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        Queue<int[]> pacificQ = new LinkedList<>();
        Queue<int[]> atlanticQ = new LinkedList<>();
        boolean[][] visitedPacific = new boolean[m][n];
        boolean[][] visitedAtlantic = new boolean[m][n];

        for (int j = 0; j < n; j++) {
            pacificQ.add(new int[]{0, j}); // first row
            atlanticQ.add(new int[]{m-1, j}); // last row
        }

        for (int i = 0; i < m; i++) {
            pacificQ.add(new int[]{i, 0}); // first column
            atlanticQ.add(new int[]{i, n-1}); // last column
        }

        bfs(pacificQ, visitedPacific, heights);
        bfs(atlanticQ, visitedAtlantic, heights);

        List<List<Integer>> ans = new ArrayList<>();

        // If a cell is visited both by BFS traversals, add to result
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visitedPacific[i][j] && visitedAtlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        
        return ans;
    }

    private void bfs(Queue<int[]> queue, boolean[][] visited, int[][] heights) {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            visited[row][col] = true;

            for (int[] dir : directions) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];
                if (0 <= nextRow && nextRow < m && 0 <= nextCol && nextCol < n
                    && !visited[nextRow][nextCol]) {
                    if (heights[nextRow][nextCol] >= heights[row][col]) {
                        queue.add(new int[]{nextRow, nextCol});
                    }
                }
            }
        }
    }

    // Time complexity: O(m * n)
    // Space complexity: O(m * n)
}
