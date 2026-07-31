class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // prices[i] = minimum cost to reach city i
        // using at most the current number of edges considered.
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        // k stops means we can use at most (k + 1) edges
        // Each iteration allows paths with one additional edge
        for (int e = 1; e <= k + 1; e++) {
            // Save result of e - 1 edges
            int[] temp = new int[n];
            for (int i = 0; i < n; i++) {
                temp[i] = prices[i];
            }

            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];

                // If we can reach city "from" using e - 1 edges, consider for e edges
                if (prices[from] != Integer.MAX_VALUE) {
                    temp[to] = Math.min(temp[to], prices[from] + cost);
                }
            }

            prices = temp;
        }
        
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
