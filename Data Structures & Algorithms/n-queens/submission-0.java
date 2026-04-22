class Solution {
    private Set<Integer> rows = new HashSet<>();
    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> diagonals = new HashSet<>();
    private Set<Integer> antiDiagonals = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        backtrack(res, new ArrayList<>(), 0, n);
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> curr, int row, int n) {
        if (row == n) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int col = 0; col < n; col++) {
            int currDiagonal = row - col;
            int currAntiDiagonal = row + col;

            if (cols.contains(col) || diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal)) {
                continue;
            }

            cols.add(col);
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);

            StringBuilder thisRow = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j != col) {
                    thisRow.append('.');
                } else {
                    thisRow.append('Q');
                }
            }

            curr.add(thisRow.toString());
            backtrack(res, curr, row + 1, n);

            // Backtrack
            cols.remove(col);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
            curr.remove(curr.size() - 1);
        }
    }
}
