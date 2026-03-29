class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Set<Integer> visited = new HashSet<>();
        if (!dfs(0, -1, graph, visited)) {
            return false;
        }

        return visited.size() == n;
    }

    private boolean dfs(int node, int parent, List<List<Integer>> graph, Set<Integer> visited) {
        if (visited.contains(node)) {
            return false; // Cycle detected
        }

        visited.add(node);
        for (int neighbor : graph.get(node)) {
            if (neighbor != parent) {
                if (!dfs(neighbor, node, graph, visited)) {
                    return false;
                }
            }
        }

        return true;
    }
}
