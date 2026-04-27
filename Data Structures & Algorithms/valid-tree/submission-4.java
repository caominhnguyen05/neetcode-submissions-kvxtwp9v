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

        Set<Integer> visited = new HashSet<>();
        if (dfs(0, -1, visited, adjList)) {
            return false;
        }

        return visited.size() == n;
    }

    private boolean dfs(int node, int parent, Set<Integer> visited, List<List<Integer>> adjList) {
        visited.add(node);

        for (int nei : adjList.get(node)) {
            if (!visited.contains(nei)) {
                if (dfs(nei, node, visited, adjList)) {
                    return true;
                }
            } else if (nei != parent) {
                return true; // cycle found
            }
        }

        return false;
    }
}
