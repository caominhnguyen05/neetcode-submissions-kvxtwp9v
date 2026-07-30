class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adjList = new HashMap<>();
        Map<Character, Integer> indegrees = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adjList.putIfAbsent(c, new HashSet<>());
                indegrees.putIfAbsent(c, 0);
            }
        }

        // Build the graph using adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            int minLength = Math.min(w1.length(), w2.length());

            for (int j = 0; j < minLength; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if (c1 != c2) {
                    // Avoid duplicate edges
                    if (adjList.get(c1).add(c2)) {
                        indegrees.put(c2, indegrees.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        // Topological sort
        Queue<Character> queue = new LinkedList<>();

        for (char c : indegrees.keySet()) {
            if (indegrees.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder order = new StringBuilder();

        while (!queue.isEmpty()) {
            char curr = queue.poll();
            order.append(curr);

            for (char next : adjList.get(curr)) {
                indegrees.put(next, indegrees.get(next) - 1);

                if (indegrees.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }

        // If not every character was processed, a cycle exists.
        return order.length() == indegrees.size() ? order.toString() : "";
    }
}
