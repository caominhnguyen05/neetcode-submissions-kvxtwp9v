class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // dp[i] = minimum cost to reach node i using k edges
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[src] = 0;

        for (int e = 1; e <= k + 1; e++) {
            // Save result of e - 1 edges
            int[] temp = new int[n];
            for (int i = 0; i < n; i++) {
                temp[i] = dp[i];
            }

            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];

                // If we can reach from using e - 1 edges, consider for e edge
                if (dp[from] != Integer.MAX_VALUE) {
                    temp[to] = Math.min(temp[to], dp[from] + cost);
                }
            }
            dp = temp;
        }

        return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
    }
}