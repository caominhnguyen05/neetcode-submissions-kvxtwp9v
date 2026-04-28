class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Map<String, List<String>> patternMap = new HashMap<>();
        wordList.add(beginWord);
        for (String w : wordList) {
            for (int i = 0; i < w.length(); i++) {
                String pattern = w.substring(0, i) + "*" + w.substring(i + 1);
                patternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(w);
            }
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        queue.add(beginWord);
        int res = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return res;
                }
                // Generate all possible patterns for this word
                for (int j = 0; j < word.length(); j++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);

                    if (!patternMap.containsKey(pattern)) {
                        return 0;
                    }

                    for (String nei : patternMap.get(pattern)) {
                        if (!visited.contains(nei)) {
                            visited.add(nei);
                            queue.add(nei);
                        }
                    }
                }
            }
            res++;
        }

        return 0;
    }
}
