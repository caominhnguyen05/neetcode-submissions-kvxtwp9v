class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> adjList = new ArrayList<>();
        // indegree[i] = number of prerequisites of course i
        int[] indegrees = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int from = pre[1];
            int to = pre[0];
            adjList.get(from).add(to);
            indegrees[to]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        int[] res = new int[numCourses];
        int index = 0;
        int taken = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            res[index++] = node;
            taken++;

            for (int neighbor : adjList.get(node)) {
                indegrees[neighbor]--;
                if (indegrees[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return taken == numCourses ? res : new int[]{};
    }
}
