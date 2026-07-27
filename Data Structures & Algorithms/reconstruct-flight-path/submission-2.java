class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }

        List<String> res = new ArrayList<>();

        // DFS visits each edge once, each poll takes O(log E) -> Total O(E log E)
        dfs("JFK", graph, res);
        Collections.reverse(res);

        return res;
    }

    private void dfs(String node, Map<String, PriorityQueue<String>> graph, List<String> res) {
        PriorityQueue<String> neighbors = graph.get(node);

        while (neighbors != null && !neighbors.isEmpty()) {
            String nei = neighbors.poll();
            dfs(nei, graph, res);
        }

        res.add(node);
    }
}
