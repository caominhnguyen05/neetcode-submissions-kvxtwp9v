class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            // Performing n & (n-1) removes the rightmost 1 bit from n
            n = n & (n - 1);
            res++;
        }

        return res;
    }
}
