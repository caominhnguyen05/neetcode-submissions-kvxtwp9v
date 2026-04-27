class Solution {
    private int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        // Initialize parent array where each node is its own parent initially
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Process each edge in order
        for (int[] edge : edges) {
            int rootU = find(edge[0] - 1);
            int rootV = find(edge[1] - 1);

            // If u and v are already in the same component
            // this edge creates a cycle -> redundant
            if (rootU == rootV) {
                return edge;
            }

            // Union: connect the two components by making one root the parent of the other
            parent[rootU] = rootV;
        }

        return new int[]{};
    }

    private int find(int x) {
        // If x is not its own parent, recursively find the root and compress the path
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }
}