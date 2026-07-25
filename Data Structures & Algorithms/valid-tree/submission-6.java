class Solution {
    public boolean validTree(int n, int[][] edges) {
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

        int numConnectedComponents = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                numConnectedComponents++;
                if (numConnectedComponents > 1) {
                    return false;
                }
                dfs(i, -1, adjList, visited);
            }
        }

        return true;
    }

    private void dfs(int node, int parent, List<List<Integer>> adjList, boolean[] visited) {
        visited[node] = true;

        for (int next : adjList.get(node)) {
            if (!visited[next] && next != parent) {
                dfs(next, node, adjList, visited);
            }
        }
    }
}
