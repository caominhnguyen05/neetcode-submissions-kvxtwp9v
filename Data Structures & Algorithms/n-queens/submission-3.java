class Solution {
    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> diagonals = new HashSet<>();
    private Set<Integer> antiDiagonals = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(res, board, 0, n);

        return res;
    }

    private void backtrack(List<List<String>> res, char[][] board, int row, int n) {
        // Found a valid placement
        if (row == n) {
            List<String> curr = new ArrayList<>();
            for (char[] r : board) {
                curr.add(new String(r));
            }

            res.add(curr);
            return;
        }

        // Try placing a queen in every column of this row
        for (int col = 0; col < n; col++) {
            int diagonal = row - col;
            int antiDiagonal = row + col;

            if (cols.contains(col) || diagonals.contains(diagonal) || antiDiagonals.contains(antiDiagonal)) {
                continue;
            }

            // Place queen
            cols.add(col);
            diagonals.add(diagonal);
            antiDiagonals.add(antiDiagonal);
            board[row][col] = 'Q';

            backtrack(res, board, row + 1, n);

            // Remove queen (backtrack)
            cols.remove(col);
            diagonals.remove(diagonal);
            antiDiagonals.remove(antiDiagonal);
            board[row][col] = '.';
        }
    }

    // Time: O(n!)
    // Space: O(n^2)
}
