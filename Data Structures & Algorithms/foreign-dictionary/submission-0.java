class Solution {
    private Map<Character, Set<Character>> adjList;
    private Map<Character, Boolean> visited;
    private List<Character> result;

    public String foreignDictionary(String[] words) {
        adjList = new HashMap<>();
        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adjList.putIfAbsent(c, new HashSet<>());
            }
        }

        // Build adjacency list / graph
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int minLen = Math.min(w1.length(), w2.length());
            
            // Invalid if longer word comes first and start with shorter word
            if (w1.length() > w2.length() && 
                w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                    return "";
            }

            for (int j = 0; j < minLen; j++) {
                // Find first different character of two words
                if (w1.charAt(j) != w2.charAt(j)) {
                    adjList.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        visited = new HashMap<>();
        result = new ArrayList<>();
        for (char c : adjList.keySet()) {
            if (dfs(c)) {
                return "";
            }
        }

        Collections.reverse(result);
        StringBuilder sb = new StringBuilder();
        for (char c : result) {
            sb.append(c);
        }

        return sb.toString();
    }

    // dfs return true if there is a cycle
    private boolean dfs(char ch) {
        if (visited.containsKey(ch)) {
            return visited.get(ch);
        }

        // Mark this node as visiting
        visited.put(ch, true);
        for (char neighbor : adjList.get(ch)) {
            if (dfs(neighbor)) {
                return true;
            }
        }
        visited.put(ch, false); // mark as already visited
        result.add(ch);
        return false;
    }
}
