class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Build adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // Find the indegree (number of prerequisites) of each course
        int[] indegrees = new int[numCourses];

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];

            adjList.get(prerequisite).add(course);
            indegrees[course]++;
        }

        // Add all courses with indegree 0 to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int[] res = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            res[index++] = currCourse;

            for (int next : adjList.get(currCourse)) {
                indegrees[next]--;

                if (indegrees[next] == 0) {
                    queue.add(next);
                }
            }
        }

        return index == numCourses ? res : new int[]{}; 
    }
}
