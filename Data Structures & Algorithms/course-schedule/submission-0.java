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
        if (state[node] == 1) {
            return true; // cycle found
        }

        if (state[node] == 2) {
            return false;
        }

        state[node] = 1;

        for (int neighbor : adjList.get(node)) {
            if (dfs(neighbor, adjList, state)) {
                return true;
            }
        }
        state[node] = 2;

        return false;
    }
}
