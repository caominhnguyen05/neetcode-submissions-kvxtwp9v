class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Multi-source BFS from 'O' cells in the borders
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            for (int[] dir : directions) {
                int nRow = row + dir[0];
                int nCol = col + dir[1];

                if (0 <= nRow && nRow < m && 0 <= nCol && nCol < n && board[nRow][nCol] == 'O' && !visited[nRow][nCol]) {
                    queue.add(new int[]{nRow, nCol});
                    visited[nRow][nCol] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
