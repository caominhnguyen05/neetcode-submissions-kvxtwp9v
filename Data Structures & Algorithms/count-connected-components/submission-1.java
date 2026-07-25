class Solution {
    public int countComponents(int n, int[][] edges) {
        // Build adjacency list of the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int numConnectedComponents = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                numConnectedComponents++;
                dfs(i, graph, visited);
            }
        }

        return numConnectedComponents;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }
}
