class Solution {
    boolean[] cols, diag, antiDiag;
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();

        cols = new boolean[n];
        diag = new boolean[2 * n];
        antiDiag = new boolean[2 * n];

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(0, n, board);

        return res;
    }

    private void backtrack(int row, int n, char[][] board) {
        if (row == n) {
            List<String> curr = new ArrayList<>();
            for (char[] r : board) {
                curr.add(new String(r));
            }
            res.add(curr);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols[col] || diag[row - col + n] || antiDiag[row + col]) {
                continue;
            }

            cols[col] = true;
            diag[row - col + n] = true;
            antiDiag[row + col] = true;
            board[row][col] = 'Q';

            backtrack(row + 1, n, board);

            board[row][col] = '.';
            cols[col] = false;
            diag[row - col + n] = false;
            antiDiag[row + col] = false;
        }
    }
}