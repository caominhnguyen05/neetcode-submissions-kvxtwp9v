class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        int powerOfTwo = 1;

        for (int i = 1; i <= n; i++) {
            if (powerOfTwo * 2 == i) {
                powerOfTwo *= 2;
            }

            ans[i] = ans[i - powerOfTwo] + 1;
        }

        return ans;
    }
}
