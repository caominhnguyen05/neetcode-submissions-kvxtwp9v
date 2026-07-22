public class TrieNode {
    TrieNode[] children;
    String word;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.word = null;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insertWord(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.word = word;
    }
}

class Solution {
    private int m;
    private int n;

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();

        for (String w : words) {
            trie.insertWord(w);
        }

        m = board.length;
        n = board[0].length;
        List<String> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, board, trie.root, res);
            }
        }

        return res;
    }

    private void dfs(int row, int col, char[][] board, TrieNode root, List<String> res) {
        char c = board[row][col];

        // already visited or no trie path
        if (c == '#' || root.children[c - 'a'] == null) {
            return;
        }

        TrieNode next = root.children[c - 'a'];
        if (next.word != null) {
            res.add(next.word);
            next.word = null; // avoid duplicates
        }

        // mark as visited
        board[row][col] = '#';

        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : directions) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                dfs(nr, nc, board, next, res);
            }
        }

        // Unmark this cell to backtrack
        board[row][col] = c;
    }
}
