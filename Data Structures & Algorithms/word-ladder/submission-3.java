class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        // If endword is not reachable
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(beginWord);
        visited.add(beginWord);

        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process current BFS level
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return steps;
                }

                char[] chars = word.toCharArray();

                // Try changing every character
                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];

                    for (int k = 0; k < 26; k++) {
                        char newChar = (char) ('a' + k);
                        if (newChar == original) {
                            continue;
                        }

                        chars[j] = newChar;
                        String nextWord = new String(chars);

                        if (wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                            visited.add(nextWord);
                            queue.offer(nextWord);
                        }
                    }

                    chars[j] = original;
                }
            }
            steps++;
        }

        return 0;
    }
}
