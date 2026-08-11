class Solution {
    public double myPow(double x, int n) {
        return n < 0 ? 1 / positivePow(x, -n) : positivePow(x, n);
    }

    private double positivePow(double x, int n) {
        if (n == 0) return 1;

        double half = positivePow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        }

        return half * half * x;
    }
}
