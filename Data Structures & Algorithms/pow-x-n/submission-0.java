class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / positivePow(x, -n);
        }
        return positivePow(x, n);
    }

    private double positivePow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n % 2 == 1) {
            return x * positivePow(x, n - 1);
        }
        double half = positivePow(x, n / 2);

        return half * half;
    }
}
