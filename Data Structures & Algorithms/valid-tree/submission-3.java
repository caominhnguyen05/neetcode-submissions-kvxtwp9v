class Solution {
    public boolean validTree(int n, int[][] edges) {
        // A graph is a valid tree iff: number of edges = n - 1, graph is connected
        if (edges.length != n - 1) {
            return false;
        }

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        dfs(0, adjList, visited);

        // If all nodes are visited, the graph is connected
        int visitedCount = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                visitedCount++;
            }
        }

        return visitedCount == n;
    }

    private void dfs(int node, List<List<Integer>> adjList, boolean[] visited) {
        visited[node] = true;

        for (int nei : adjList.get(node)) {
            if (!visited[nei]) {
                dfs(nei, adjList, visited);
            }
        }
    }
}
