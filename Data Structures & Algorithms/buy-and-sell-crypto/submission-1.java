class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int lowestSoFar = prices[0];

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - lowestSoFar);
            lowestSoFar = Math.min(prices[i], lowestSoFar);
        }

        return maxProfit;
    }
}
