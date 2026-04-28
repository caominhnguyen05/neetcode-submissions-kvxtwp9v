class Solution {
    private StringBuilder res = new StringBuilder();

    public String foreignDictionary(String[] words) {
        int n = words.length;
        Map<Character, Set<Character>> graph = new HashMap<>();
        int[] indegrees = new int[26];

        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        // Build adjacency list to represent graph
        for (int i = 0; i < n - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            int minLen = Math.min(word1.length(), word2.length());
            for (int j = 0; j < minLen; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.get(word1.charAt(j)).add(word2.charAt(j));
                    break;
                }
            }
        }

        int[] state = new int[26];

        // DFS on all nodes
        for (char c : graph.keySet()) {
            if (state[c - 'a'] == 0) {
                if (hasCycle(c, graph, state)) {
                    return "";
                }
            }
        }

        

        return res.reverse().toString();
    }

    private boolean hasCycle(char node, Map<Character, Set<Character>> graph, int[] state) {
        state[node - 'a'] = 1; // mark as visiting

        for (char nei : graph.get(node)) {
            if (state[nei - 'a'] == 1) {
                return true; // cycle detected
            }

            if (state[nei - 'a'] == 0) {
                if (hasCycle(nei, graph, state)) {
                    return true;
                }
            }
        }
        state[node - 'a'] = 2; // mark as visited
        res.append(node);
        return false;
    }
}
