class Solution {
    private static final int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m;
    private int n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0, board, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int row, int col, int i, char[][] board, String target) {
        if (board[row][col] != target.charAt(i)) {
            return false;
        }

        if (i == target.length() - 1) {
            return true;
        }

        char temp = board[row][col];
        board[row][col] = '#'; // mark as visited

        for (int[] dir : directions) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] != '#') {
                if (dfs(nr, nc, i + 1, board, target)) {
                    return true;
                }
            }
        }

        board[row][col] = temp;
        return false;
    }
}
