class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            adjList.get(pre[1]).add(pre[0]);
        }

        int[] state = new int[numCourses]; // 0=unvisited, 1=visiting, 2=visited

        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, adjList, state)) {
                return false; // there is a cycle
            }
        }

        return true;
    }

    private boolean dfs(int node, List<List<Integer>> adjList, int[] state) {
        state[node] = 1; // mark as visiting

        for (int neighbor : adjList.get(node)) {
            if (state[neighbor] == 1) {
                return true;
            }

            if (state[neighbor] == 0) {
                if (dfs(neighbor, adjList, state)) {
                    return true;
                }
            }
        }

        state[node] = 2; // mark as visited
        return false;
    }
}
