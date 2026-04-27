class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // BFS from all border O's to find regions connected to border O's
        // After the BFS, if an O cell is not visited, change to X
        
        Queue<int[]> queue = new LinkedList<>();
        
        // Find O cells on left and right borders
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                queue.add(new int[]{i, 0});
            }
            if (board[i][n-1] == 'O') {
                queue.add(new int[]{i, n-1});
            }
        }

        // Find O cells on top and bottom borders
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                queue.add(new int[]{0, j});
            }
            if (board[m-1][j] == 'O') {
                queue.add(new int[]{m-1, j});
            }
        }

        boolean[][] visited = new boolean[m][n];
        int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            
            board[row][col] = 'T'; // mark as visited

            for (int[] dir : directions) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];

                if (0 <= nextRow && nextRow < m && 0 <= nextCol && nextCol < n && !visited[nextRow][nextCol]) {
                    if (board[nextRow][nextCol] == 'O') {
                        queue.add(new int[]{nextRow, nextCol});
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
