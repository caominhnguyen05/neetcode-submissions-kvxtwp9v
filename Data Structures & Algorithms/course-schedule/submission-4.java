class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // inDegree[i] = number of prerequisites of course i
        int[] inDegrees = new int[numCourses];

        for (int[] pre : prerequisites) {
            int from = pre[1];
            int to = pre[0];
            inDegrees[to]++;
            adjList.get(from).add(to);
        }

        Queue<Integer> queue = new LinkedList<>();
        int taken = 0;

        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            taken++;

            for (int neighbor : adjList.get(curr)) {
                inDegrees[neighbor]--;
                if (inDegrees[neighbor] == 0) {
                    queue.add(neighbor); // we can take this course next
                }
            }
        }

        return taken == numCourses;
    }

    // Time complexity: O(V + E)
    // Space complexity: O(V + E)
}
