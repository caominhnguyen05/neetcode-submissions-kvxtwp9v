class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') continue;

                int num = board[row][col] - '1';
                int boxIndex = (row / 3) * 3 + col / 3;

                // If already seen -> invalid
                if (rows[row][num] || cols[col][num] || boxes[boxIndex][num]) {
                    return false;
                }
                
                rows[row][num] = true;
                cols[col][num] = true;
                boxes[boxIndex][num] = true;
            }
        }

        return true;
    }
}
