class TrieNode {
    TrieNode[] children;
    String word;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.word = null;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insertWord(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = word;
    }
}

class Solution {
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m;
    private int n;

    
    public List<String> findWords(char[][] board, String[] words) {
        // Build a trie to store the words
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

    private void dfs(int row, int col, char[][] board, TrieNode node, List<String> res) {
        char c = board[row][col];
        TrieNode curr = node.children[c - 'a'];

        if (curr == null) {
            return;
        }

        if (curr.word != null) {
            res.add(curr.word);
            curr.word = null; // avoid duplicates
        }

        board[row][col] = '#'; // mark this cell as visited

        for (int[] dir : directions) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (0 <= nr && nr < m && 0 <= nc && nc < n && board[nr][nc] != '#') {
                dfs(nr, nc, board, curr, res);
            }
        }

        board[row][col] = c;
    }
}
