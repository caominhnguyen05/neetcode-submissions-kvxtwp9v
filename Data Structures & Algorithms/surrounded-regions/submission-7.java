class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Multi-source BFS from 'O' cells in the borders
        Queue<int[]> queue = new LinkedList<>();

        // Add all 'O' cells on the borders
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
                    queue.add(new int[]{i, j});
                    board[i][j] = '#'; // mark as safe
                }
            }
        }

        int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        // BFS to mark all connected 'O's
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            for (int[] dir : directions) {
                int nRow = row + dir[0];
                int nCol = col + dir[1];

                if (0 <= nRow && nRow < m && 0 <= nCol && nCol < n && board[nRow][nCol] == 'O') {
                    queue.add(new int[]{nRow, nCol});
                    board[nRow][nCol] = '#'; // mark visited/safe
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; // surrounded
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O'; // restore safe region
                }
            }
        }
    }
}
