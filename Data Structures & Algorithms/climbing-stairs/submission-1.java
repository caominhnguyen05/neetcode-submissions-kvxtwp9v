class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;

        // prev1 = ways to reach (i-1)
        // prev2 = ways to reach (i-2)
        int prev2 = 1;
        int prev1 = 1;

        for (int i = 2; i <= n; i++) {
            // current = ways(i-1) + ways(i-2)
            int current = prev2 + prev1;

            // shift states forward
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
