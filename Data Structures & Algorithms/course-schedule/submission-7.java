class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            adjList.get(pre[1]).add(pre[0]);
        }

        // 0 = unvisited, 1 = visiting, 2 = visited
        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (hasCycle(i, adjList, state)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasCycle(int course, List<List<Integer>> adjList, int[] state) {
        if (state[course] == 1) {
            return true; // has cycle
        }

        if (state[course] == 2) {
            return false;
        }

        state[course] = 1; // mark as visiting
        for (int neighbor : adjList.get(course)) {
            if (hasCycle(neighbor, adjList, state)) {
                return true;
            }
        }

        state[course] = 2;
        return false;
    }
}
