class Solution {
    private int n;
    private int m;
    private String target;
    private int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private boolean[][] seen;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        target = word;
        seen = new boolean[m][n];

        // Find starting points for backtracking, which is all characters that is word[0]
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    seen[i][j] = true;
                    if (backtrack(i, j, 1, board)) {
                        return true;
                    }
                    seen[i][j] = false;
                }
            }
        }

        return false;
    }

    public boolean backtrack(int row, int col, int i, char[][] board) {
        if (i == target.length()) {
            return true;
        }

        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if (0 <= nextRow && nextRow < m && 0 <= nextCol && nextCol < n && !seen[nextRow][nextCol]) {
                // If the cell contains character we're looking for, add it
                if (board[nextRow][nextCol] == target.charAt(i)) {
                    seen[nextRow][nextCol] = true;
                    if (backtrack(nextRow, nextCol, i + 1, board)) {
                        return true;
                    }

                    // Backtrack - remove this character
                    seen[nextRow][nextCol] = false;
                }
            }
        }

        return false;
    }
}
