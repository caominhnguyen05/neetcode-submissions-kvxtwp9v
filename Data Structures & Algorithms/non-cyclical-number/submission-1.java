class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1) {
            n = sumOfSquares(n);
            if (seen.contains(n)) {
                return false;
            }
            seen.add(n);
        }

        return true;
    }

    private int sumOfSquares(int n) {
        int sum = 0;

        while (n != 0) {
            int lastDigit = n % 10;
            sum += lastDigit * lastDigit;
            n /= 10;
        }

        return sum;
    }
}
