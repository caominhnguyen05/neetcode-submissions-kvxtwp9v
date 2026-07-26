class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        UnionFind uf = new UnionFind(n + 1);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (!uf.union(u, v)) {
                return edge;
            }
        }

        return new int[0];
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // path compression
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX == rootY) {
                return false; // cycle detected
            }

            // Union by rank
            if (rank[x] < rank[y]) {
                parent[rootX] = rootY;
            } else if (rank[x] > rank[y]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }

            return true;
        }
    }
}
