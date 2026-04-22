class Solution {
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
        if (i == target.length()) {
            return true;
        }

        if (row < 0 || row >= m || col < 0 || col >= n || 
            board[row][col] != target.charAt(i) || board[row][col] == '#') {
            return false;
        }

        board[row][col] = '#';
        boolean res = dfs(row, col + 1, i + 1, board, target) || 
                      dfs(row + 1, col, i + 1, board, target) ||
                      dfs(row, col - 1, i + 1, board, target) ||
                      dfs(row - 1, col, i + 1, board, target);
        // backtrack - remove this character
        board[row][col] = target.charAt(i);

        return res;
    }
}
